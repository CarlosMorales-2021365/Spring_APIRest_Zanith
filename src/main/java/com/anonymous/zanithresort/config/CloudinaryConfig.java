
package com.anonymous.zanithresort.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dbwizu9vw",
                "api_key","875866635552793",
                "api_secret","vHYYRRLSzn18Ec6f73JEha4imVA"
        ));
    }
}

