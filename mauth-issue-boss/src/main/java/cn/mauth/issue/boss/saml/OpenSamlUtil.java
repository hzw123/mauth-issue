package cn.mauth.issue.boss.saml;

import cn.mauth.issue.boss.saml.exception.Saml2TokenValidationException;
import cn.mauth.issue.boss.utils.HttpUtils;
import net.shibboleth.utilities.java.support.component.ComponentInitializationException;
import net.shibboleth.utilities.java.support.xml.BasicParserPool;
import net.shibboleth.utilities.java.support.xml.SerializeSupport;
import org.joda.time.DateTime;

import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.messaging.decoder.MessageDecodingException;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.common.xml.SAMLConstants;
import org.opensaml.saml.saml2.binding.decoding.impl.HTTPPostDecoder;
import org.opensaml.saml.saml2.core.*;
import org.opensaml.saml.saml2.core.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public final class OpenSamlUtil {
    private static final Logger logger= LoggerFactory.getLogger(OpenSamlUtil.class);
    private static boolean isBootStrapped = false;
    private static final String LOGOUT_REQUEST="LogoutRequest";
    private static final String AUTHN_REQUEST="AuthnRequest";

    private OpenSamlUtil() {
        // Disabling initialization
    }

    public static Response convertToken(HttpServletRequest request) throws Exception {

        doBootstrap();

        HTTPPostDecoder decoder = new HTTPPostDecoder();
        decoder.setHttpServletRequest(request);
        try {
            BasicParserPool parserPool = new BasicParserPool();
            parserPool.initialize();
            decoder.setParserPool(parserPool);
            decoder.initialize();
            decoder.decode();

            return (Response) decoder.getMessageContext().getMessage();
        } catch (MessageDecodingException e) {
            throw new RuntimeException(e);
        } catch (ComponentInitializationException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getSAMLRequest(String var1,String var2,String var3) {
        doBootstrap();

        AuthnRequestBuilder authRequestBuilder = new AuthnRequestBuilder();
        AuthnRequest authnRequest = authRequestBuilder.buildObject(SAMLConstants.SAML20P_NS, AUTHN_REQUEST, "samlp");
        authnRequest.setIsPassive(false);
        authnRequest.setForceAuthn(false);
        authnRequest.setIssueInstant(new DateTime());
        authnRequest.setProtocolBinding(SAMLConstants.SAML2_POST_BINDING_URI);
        authnRequest.setAssertionConsumerServiceURL(var2);
        authnRequest.setID(new BigInteger(130, new SecureRandom()).toString(42));
        authnRequest.setVersion(SAMLVersion.VERSION_20);
        authnRequest.setDestination(var1);
        authnRequest.setProviderName("mauth-saml");

        IssuerBuilder issuerBuilder = new IssuerBuilder();
        Issuer issuer = issuerBuilder.buildObject(SAMLConstants.SAML20_NS, "Issuer", "spEntityId" );
        issuer.setValue(var3);
        authnRequest.setIssuer(issuer);

        NameIDPolicyBuilder nameIdPolicyBuilder = new NameIDPolicyBuilder();
        NameIDPolicy nameIdPolicy = nameIdPolicyBuilder.buildObject();
        nameIdPolicy.setSchemaLocation(SAMLConstants.SAML20P_NS);
        nameIdPolicy.setFormat("urn:oasis:names:tc:SAML:2.0:nameid-format:persistent");
        nameIdPolicy.setSPNameQualifier(var2);
        nameIdPolicy.setAllowCreate(true);
        authnRequest.setNameIDPolicy(nameIdPolicy);

        RequestedAuthnContextBuilder requestedAuthnContextBuilder = new RequestedAuthnContextBuilder();
        RequestedAuthnContext requestedAuthnContext = requestedAuthnContextBuilder.buildObject();
        requestedAuthnContext.setComparison(AuthnContextComparisonTypeEnumeration.EXACT);

        AuthnContextClassRefBuilder authnContextClassRefBuilder = new AuthnContextClassRefBuilder();
        AuthnContextClassRef authnContextClassRef = authnContextClassRefBuilder.buildObject(SAMLConstants.SAML20_NS, "AuthnContextClassRef", "saml");
        authnContextClassRef.setAuthnContextClassRef("urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport");

        requestedAuthnContext.getAuthnContextClassRefs().add(authnContextClassRef);
        authnRequest.setRequestedAuthnContext(requestedAuthnContext);
        return getSamlRequest(authnRequest);
    }

    private static String getSamlRequest(XMLObject var1){
        Marshaller marshaller = XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(var1);
        String samlRequest=null;
        try {
            samlRequest=SerializeSupport.prettyPrintXML(marshaller.marshall(var1));

            samlRequest=deflatedBase64encoded(samlRequest);

            samlRequest=URLEncoder.encode(samlRequest,"UTF-8");
        }catch (MarshallingException e){
            logger.error(e.getMessage());
        }catch (UnsupportedEncodingException e){
            logger.error(e.getMessage());
        }
        return samlRequest;
    }

    public static String getLogoutRequest(String var1,String var2,String var3){
        LogoutRequestBuilder logoutRequestBuilder=new LogoutRequestBuilder();

        LogoutRequest logoutRequest=logoutRequestBuilder.buildObject(SAMLConstants.SAML20P_NS, LOGOUT_REQUEST, "samlp");

        logoutRequest.setID(new BigInteger(130, new SecureRandom()).toString(42));

        logoutRequest.setSchemaLocation(SAMLConstants.SAML20P_NS);
        logoutRequest.setVersion(SAMLVersion.VERSION_20);
        logoutRequest.setDestination(var1);
        logoutRequest.setNil(false);

        DateTime issueInstant = new DateTime();
        logoutRequest.setIssueInstant(issueInstant);
        logoutRequest.setNotOnOrAfter(new DateTime(issueInstant.getMillis() + 5 * 60 * 1000));

        IssuerBuilder issuerBuilder = new IssuerBuilder();
        Issuer issuer = issuerBuilder.buildObject(SAMLConstants.SAML20_NS, "Issuer", "spEntityId" );
        issuer.setValue(var3);
        logoutRequest.setIssuer(issuer);

        NameIDBuilder nameIDBuilder=new NameIDBuilder();
        NameID nameId = nameIDBuilder.buildObject(SAMLConstants.SAML20_NS,"NameID","saml");
        nameId.setFormat("urn:oasis:names:tc:SAML:2.0:nameid-format:entity");
        nameId.setSPNameQualifier(var2);
        nameId.setValue("idp.mauth.cb");
        nameId.setNameQualifier(HttpUtils.getAccount());
        logoutRequest.setNameID(nameId);

        SessionIndexBuilder sessionIndexBuilder=new SessionIndexBuilder();
        SessionIndex sessionIndex = sessionIndexBuilder.buildObject(SAMLConstants.SAML20P_NS,"SessionIndex","samlp");
        sessionIndex.setSessionIndex(HttpUtils.getSessionIndex());
        logoutRequest.getSessionIndexes().add(sessionIndex);

        logoutRequest.setReason("urn:oasis:names:tc:SAML:2.0:logout:user");

        return getSamlRequest(logoutRequest);
    }

    private static String deflatedBase64encoded(String input) {
        // Deflater
        ByteArrayOutputStream bytesOut=null;
        try{
            bytesOut= new ByteArrayOutputStream();
            Deflater deflater = new Deflater(Deflater.DEFLATED, true);
            DeflaterOutputStream deflaterStream = new DeflaterOutputStream(bytesOut, deflater);
            deflaterStream.write(input.getBytes(Charset.forName("UTF-8")));
            deflaterStream.finish();
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        // Base64 encoder
        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytesOut.toByteArray()));
    }

    private static void doBootstrap() throws Saml2TokenValidationException {
        if (!isBootStrapped) {
            try {
                InitializationService.initialize();
                isBootStrapped = true;
            } catch (InitializationException e) {
                throw new Saml2TokenValidationException(
                        "OpenSAML bootstrap configuration failed.", e);
            }
        }
    }
}
