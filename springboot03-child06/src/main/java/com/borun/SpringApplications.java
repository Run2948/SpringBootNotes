package com.borun;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

// 默认情况下扫描的是当前包及当前包的子包，所以可以根据具体情况来指定是否需要扫描
@SpringBootApplication(scanBasePackages = {"com.borun.controller"}) // 组合注解
public class SpringApplications { //extends WebMvcConfigurerAdapter {

    // 入口
    public static void main(String[] args) {
        SpringApplication.run(SpringApplications.class, args);
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //super.configureMessageConverters(converters);
//        // 创建 FastJson 的消息转换器
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        // 创建 FastJson 的配置对象
//        FastJsonConfig email = new FastJsonConfig();
//        // 对 Json 数据进行格式化
//        email.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        converter.setFastJsonConfig(email);
//        converters.add(converter);
//    }

    @Bean
    public HttpMessageConverters fastJsonMessageConverter() {
        // 创建 FastJson 的消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 创建 FastJson 的配置对象
        FastJsonConfig config = new FastJsonConfig();
        // 对 Json 数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 设置 FastJson 配置
        converter.setFastJsonConfig(config);
        // 设置 HttpMessageConverter
        HttpMessageConverter<?> con = converter;
        return new HttpMessageConverters(con);
    }

}


