package com.wowcher.test;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author pbonansea
 *
 */
public interface UploadImage {

    boolean uploadImage(byte[] inputStream, Path folder, String fileName) 
            throws IllegalArgumentException, IOException;
    
}
