package rest;

import car.filter.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<ValidationFilter> validationFilter() {
        FilterRegistrationBean<ValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ValidationFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1); // order matters
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(3);
        return registrationBean;
    }

}
