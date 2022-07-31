package it2.develhope.Angelo.InterceptormiddlewareExample.configurations;

import it2.develhope.Angelo.InterceptormiddlewareExample.interceptor.APILoggingInterceptor;
import it2.develhope.Angelo.InterceptormiddlewareExample.interceptor.LoggedUserInterceptor;
import it2.develhope.Angelo.InterceptormiddlewareExample.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMCSConfiguration implements WebMvcConfigurer {

    //inseriamo i nostri interceptor
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private TestInterceptor testInterceptor;

    @Autowired
    private LoggedUserInterceptor loggedUserInterceptor;

    //aggiunge gli interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) { //importante l'ordine in cui vengono inseriti gli interceptor
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(testInterceptor);
        registry.addInterceptor(loggedUserInterceptor);
    }
}
