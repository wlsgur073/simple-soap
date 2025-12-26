package com.example.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@EnableWs
//@Configuration
@Configuration(proxyBeanMethods = false)
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/soap/*");
    }

    @Bean
    public DefaultWsdl11Definition userService(SimpleXsdSchema user) {
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setPortTypeName("UserPort");
        def.setLocationUri("/soap/user");
        def.setTargetNamespace("http://example.com/user");
        def.setSchema(user);
        return def;
    }

    @Bean
    public SimpleXsdSchema user() {
        return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/user.xsd"));
    }


}