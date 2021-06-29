package com.cardcoupon.passbook.conf;

import com.cardcoupon.passbook.security.AuthCheckInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Slf4j
@Component
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * Self-defined interception patterns
     * @param registry Helps with configuring a list of mapped interceptors
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("Add Interceptor: AuthCheckInterceptor");
        registry.addInterceptor(new AuthCheckInterceptor())
                .addPathPatterns("/merchants/**")
                .order(0);
        super.addInterceptors(registry);
    }

}
