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
            "cloud_name", "Untitled",
            "api_key", "574739935484963",
            "api_secret", "kd7N9NEto4ZagM_qG9vEmORrSjQ"
            
        ));
        
    }

}
