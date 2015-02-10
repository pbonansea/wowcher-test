package com.wowcher.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

/**
 * @author pbonansea
 *
 */
@Service
public class UploadImageImpl implements UploadImage {

    @Override
    public boolean uploadImage(final byte[] content, final Path folderPath, 
            final String fileName) throws IllegalArgumentException, IOException {

        if (content == null) {
            throw new IllegalArgumentException("The file content should not be null");
        }
        
        Path userFolderPath = (folderPath == null) ? 
                Paths.get(System.getProperty("user.dir")) :
                Paths.get(System.getProperty("user.dir")).resolve(folderPath);
        
        Files.createDirectories(userFolderPath);        
        
        Files.write(userFolderPath.resolve(fileName), content);
        
        return true;
        
    }

}
