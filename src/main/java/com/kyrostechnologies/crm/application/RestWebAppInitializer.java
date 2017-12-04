package com.kyrostechnologies.crm.application;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class RestWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletInitializer.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/CRM/v1/*" };
    }


    @Override
    protected String getServletName() {
        return "rest-exporter";
    }
}
