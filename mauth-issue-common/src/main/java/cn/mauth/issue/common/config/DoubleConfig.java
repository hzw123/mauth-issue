package cn.mauth.issue.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class DoubleConfig implements Converter<String,Double> {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public Double convert(String s) {
        double num=0;
        try{
            num= Double.parseDouble(s);
        }catch (Exception e){
            logger.info("string transform Double fail!"+e);
        }

        return num;
    }

}
