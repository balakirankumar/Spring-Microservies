package com.rest.microservices.currencyconversionservice.config;

import com.rest.microservices.currencyconversionservice.interceptor.RequestValidatorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class AppMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RequestValidatorInterceptor requestValidatorInterceptor;

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(requestValidatorInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("");
    }
}
