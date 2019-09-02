package com.borun;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

// 默认情况下扫描的是当前包及当前包的子包，所以可以根据具体情况来指定是否需要扫描
@SpringBootApplication(scanBasePackages = {"com.borun.controller", "com.borun.service", "com.borun.pojo", "com.borun.config"})
// 组合注解
@MapperScan("com.borun.mapper")
@EnableCaching // Redis单服务开启缓存
public class SpringApplications {

    // 入口
    public static void main(String[] args) {
        SpringApplication.run(SpringApplications.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        convert.setFastJsonConfig(config);

        HttpMessageConverter<?> con = convert;
        return new HttpMessageConverters(con);
    }

}


