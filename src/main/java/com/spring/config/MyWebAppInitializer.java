package com.spring.config;

import com.spring.ApplicationConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 16:57
 **/
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ApplicationConfig.class };
    }

    /**
     *过滤的路径
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "*.do" };
    }


}
