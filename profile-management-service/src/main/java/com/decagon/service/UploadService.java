package com.decagon.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    @Autowired
    private Cloudinary cloudinary;

    public String imageLink(MultipartFile file, String id) {
        String url = "";
        try {
            cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", "image_id" + id));
            url = cloudinary.url().transformation(new Transformation().width(200).height(250).crop("fill")).generate("image_id" + id);
            System.out.println(url);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return url;
    }
}
