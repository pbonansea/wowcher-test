package com.wowcher.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

/**
 * @author pbonansea
 *
 */
public class UploadImageTest {

    private UploadImage uploadImage;
    
    private static final String FILE_NAME = "test.jpg";
    
    private Path userDirPath;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        
        uploadImage = new UploadImageImpl();

        userDirPath = Paths.get(System.getProperty("user.dir"));
        
    }

    @Test
    public void testUploadFileWithoutFolder() throws Exception {


        Path filePath = userDirPath.resolve(FILE_NAME);

        boolean result = uploadImage.uploadImage("".getBytes(), null, filePath.getFileName().toString());
        
        assertThat("upload image result should be true", result,
                equalTo(true));
        
        assertThat("image should exists in the file system", Files.exists(filePath),
                equalTo(true));

        Files.deleteIfExists(filePath);
        
    }

    @Test
    public void testUploadFileWithFolder() throws Exception {

        Path tempFolder = userDirPath.resolve("temp");
        
        boolean result = uploadImage.uploadImage("".getBytes(), tempFolder, FILE_NAME);
        
        assertThat("upload image result should be true", result,
                equalTo(true));
        
        assertThat("image should exists in the file system", Files.exists(tempFolder
                .resolve(FILE_NAME)), equalTo(true));
        
        Files.deleteIfExists(tempFolder.resolve(FILE_NAME));

        Files.deleteIfExists(tempFolder);

    }

    @Test
    public void testUploadFileWithException() {

        try {

           uploadImage.uploadImage(null, null, FILE_NAME);

        } catch (Exception ex) {
            assertThat("exception content null", ex.getMessage(),
                    equalTo("The file content should not be null"));            
        }
    }

}
