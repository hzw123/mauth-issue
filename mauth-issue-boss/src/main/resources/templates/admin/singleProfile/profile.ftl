<#include "/macro/base.ftl" />
<div class="bjui-pageContent" >
    <form action="${base}/admin/singleProfile/update" data-toggle="validate" method="post" style="margin: auto;padding: 50px 13px;">
        <input style="width: 500px;padding:20px" class="form-control" type="hidden" name="name" value="${bean.name}"/>
        <table style="width: 80%;" border="0" cellpadding="0" cellspacing="0">
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>修改时间:</strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control"
                           type="text"
                           name="upTime"
                           value="${(bean.upTime?string('yyyy-MM-dd HH:mm:ss'))!}"
                           placeholder="修改时间" readonly />
                </td>
            </tr>
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>SP Entity ID: </strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control"
                           type="text"
                           name="spEntityId"
                           value="${bean.spEntityId!}"
                           placeholder="SP Entity ID"
                           data-rule="required"/>
                </td>
            </tr>
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>AssertionConsumerService:</strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control" type="text"
                           name="assertionConsumerService"
                           value="${bean.assertionConsumerService!}"
                           placeholder="AssertionConsumerService"
                           data-rule="required"/>
                </td>
            </tr>
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>singleLogoutService:</strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control"
                           type="text"
                           name="singleLogoutService"
                           value="${bean.singleLogoutService!}"
                           placeholder="singleLogoutService"
                           data-rule="required"/>
                </td>
            </tr>
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>单点登录地址:</strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control"
                           type="text"
                           name="loginUrl"
                           value="${bean.loginUrl!}"
                           placeholder="单点登录地址"
                           data-rule="required"/>
                </td>
            </tr>
            <tr style="margin:10px 0px;height: 50px;">
                <td align="right" style="width: 120px;padding-right: 15px;">
                    <strong>单点注销地址:</strong>
                </td>
                <td>
                    <input style="width: 500px;padding:20px"
                           class="form-control"
                           type="text"
                           name="logoutUrl"
                           value="${bean.logoutUrl!}"
                           placeholder="单点注销地址"
                           data-rule="required"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>