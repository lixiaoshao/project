package com.honor.springboot.config;

import com.honor.springboot.converter.EntityToStringConverter;
import com.honor.springboot.entity.User;
import com.honor.springboot.interceptor.LoginInterceptor;
import com.honor.springboot.interceptor.PathPvInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.honor.springboot.config
 *
 * @author honor-ljp
 * 2023/1/1 22:40
 */
@Configuration
public class WebConfig {
    @Autowired
    PathPvInterceptor pathPvInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 矩阵格式请求参数转换开启
             * @param configurer
             */
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            /**
             * 自定义参数转换器
             * String ---> List<User.UserRole>
             * @param registry
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, List<User.UserRole>>() {
                    @Override
                    public List<User.UserRole> convert(String source) {
                        return Arrays.stream(source.split(",")).map(s -> {
                            User.UserRole userRole = new User.UserRole();
                            userRole.setName(s);
                            return userRole;
                        }).collect(Collectors.toList());
                    }
                });
            }

            /**
             * 自定义类型消息转化器
             * @param converters
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new EntityToStringConverter());
            }

            /**
             * P42内容协商，使用configurer.strategies配置，且只配置了基于参数的内容协商，会覆盖掉原先基于请求头的内容协商，因此在后面的springboot错误页默认配置中会导致没有跳转到error/xxx.html页面，而是返回了json，是因为BasicErrorController返回为模板信息的HandlerMapping注解的produce为"text/html"使用了基于请求头的内容协商，所以要使用P42重载configureContentNegotiation进行内容协商配置，应该
             * @Autowired
             * WebMvcProperties mvcProperties;
             * ......
             * Map<String, MediaType> mediaTypes = this.mvcProperties.getContentnegotiation().getMediaTypes();
             * mediaTypes.put("custom", MediaType.parseMediaType("application/custom"));
             * mediaTypes.forEach(configurer::mediaType);
             */
            /**
             * 配置自定义的内容协商管理器
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("test", MediaType.parseMediaType("application/self-test"));
                ContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(mediaTypes);
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy, headerStrategy));
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/thymeleaf/login.html",
                                "/thymeleaf/login",
                                "/upload",
                                "/error",
                                "/druid/*");
                registry.addInterceptor(pathPvInterceptor)
                        .addPathPatterns("/**");
            }
        };
    }
}
