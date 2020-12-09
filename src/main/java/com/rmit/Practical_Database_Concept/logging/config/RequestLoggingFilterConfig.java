package com.rmit.Practical_Database_Concept.logging.config;

import com.rmit.Practical_Database_Concept.logging.filter.CustomURLFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

        filter.setIncludeQueryString(true);

        filter.setIncludePayload(true);

        filter.setMaxPayloadLength(10000);

        filter.setIncludeHeaders(false);

        filter.setAfterMessagePrefix("REQUEST DATA : ");

        return filter;
    }

    @Bean
    public FilterRegistrationBean <CustomURLFilter> filterRegistrationBean() {
        FilterRegistrationBean< CustomURLFilter > registrationBean = new FilterRegistrationBean();

        CustomURLFilter customURLFilter = new CustomURLFilter();

        registrationBean.setFilter(customURLFilter);

        registrationBean.setOrder(2); //set precedence

        return registrationBean;
    }
}
