
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
                "cloud_name","djlfcyqqb",
                "api_key","931248142449731",
                "api_secret","ALBbFvAbNnhW6a7cStRbpQaJXhU"
        ));
    }
}

