package cn.mauth.issue.util.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Api {
    String getName() default "api method";
    String value() default "/api/v1";
}
