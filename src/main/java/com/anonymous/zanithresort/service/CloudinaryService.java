package com.anonymous.zanithresort.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {

<<<<<<< HEAD
    @Autowired
    private Cloudinary cloudinary;

    public Map<String, Object> uploadImg(MultipartFile file, String folder) throws IOException{
        String originalFilename = file.getOriginalFilename();

        if(originalFilename == null){
            throw new IllegalArgumentException("El archivo no puede estar nulo");
        }

        String newName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String fileName = newName + "_" + timestamp;

        @SuppressWarnings( "unchecked")
        Map<String, Object> uploadResult = (Map<String, Object>)cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
            "folder", folder,
            "public_id", fileName
        ));

        return uploadResult;
    }
       
    
=======
@Autowired
private Cloudinary cloudinary;

public Map<String, Object> uploadImg(MultipartFile file, String folder) throws IOException{
    String originalFilename = file.getOriginalFilename();

    if(originalFilename == null){
        throw new IllegalArgumentException("El archivo no puede estar nulo");

    }

    String newName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));

    String timeStam = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    String fileName = newName + "_"+timeStam;

    @SuppressWarnings("unchheked")
    Map<String, Object> uploadResult = (Map<String, Object>)cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
        "folder",folder,
        "public_id" ,fileName
    ));

    return uploadResult;
}

>>>>>>> b4bb9312c9fe8314d562c8d67feee6225a5bd33b
}
