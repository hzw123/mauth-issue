package cn.mauth.issue.common.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class BooleanConfig implements Converter<String,Boolean> {
    @Override
    public Boolean convert(String s) {
        if(StringUtils.isNotEmpty(s)){
            if(s.equals("true")){
                return true;
            }
            if(s.equals("false")){
                return false;
            }
        }
        return false;
    }
}
