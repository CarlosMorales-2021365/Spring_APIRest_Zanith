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
<<<<<<< HEAD
            "cloud_name","dcrgnm3ud",
            "api_key", "655453188429764",
            "api_secret", "7DJJn3dB1hGQNAYYY0xM81Xr05M"
=======

                "cloud_name","djlfcyqqb",
                "api_key","931248142449731",
                "api_secret","ALBbFvAbNnhW6a7cStRbpQaJXhU"
>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
        ));
    }
}
