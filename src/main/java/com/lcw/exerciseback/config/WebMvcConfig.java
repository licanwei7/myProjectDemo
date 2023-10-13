package com.lcw.exerciseback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Licanwei
 * @Description: 后端静态资源路径映射（暂时没有用）
 * @Date 2022/4/15 15:06
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * /images/** 是静态映射
         * file:D/IMG 是文件在服务器的路径
         */
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:D/IMG/images/");
    }
}
