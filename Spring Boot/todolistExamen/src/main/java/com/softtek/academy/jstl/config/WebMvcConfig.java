package com.softtek.academy.jstl.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.softtek.academy.jstl.util.CustomObjectMapper;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	
	@Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	        mappingJackson2HttpMessageConverter.setObjectMapper(new CustomObjectMapper());
	        converters.add(mappingJackson2HttpMessageConverter);
	    }

}