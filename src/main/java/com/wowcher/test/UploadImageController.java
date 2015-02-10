package com.wowcher.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Rest controller upload image.
 * @author pbonansea
 *
 */
@RestController
public class UploadImageController {
    
    @Autowired
    private UploadImage uploadImage;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") final MultipartFile file,
            @RequestParam("caption") final String caption, @RequestParam("altTag") final String altTag) 
                    throws IllegalArgumentException, IOException {
        
        Path folderPath = null;

        if (altTag != null && !altTag.equals("")) {
            folderPath = Paths.get(altTag);   
        }

        if (caption != null && !caption.equals("")) {
            if (folderPath == null) {
                folderPath = Paths.get(caption);                   
            } else {
                folderPath = folderPath.resolve(caption);                
            }
        }

        uploadImage.uploadImage(file.getBytes(), folderPath, file.getOriginalFilename());
        
        return "OK";
        
    }
    
}
