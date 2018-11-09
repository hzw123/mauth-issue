package cn.mauth.issue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SecurityAgentApplication {

    public static void main(String[] args){
        SpringApplication.run(SecurityAgentApplication.class,args);
    }
}
