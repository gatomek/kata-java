package pl.gatomek;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryFileSystemFileTest {
    private static final String FILE_NAME = "/test/file.txt";
    private static FileSystem fs;

    @BeforeAll
    static void setUp() {
        fs = Jimfs.newFileSystem(Configuration.unix());
    }

    @AfterAll
    static void tearDown() throws IOException {
        fs.close();
    }

    @Test
    void test() throws IOException, NoSuchAlgorithmException {
        Path test = fs.getPath("/test");
        Path testDir = Files.createDirectory(test);

        File file = new File(FILE_NAME);
        boolean success = file.createNewFile();
        assertEquals(Boolean.TRUE, success);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("test");
        }

        byte[] data = Files.readAllBytes(file.toPath());
        byte[] hash = MessageDigest.getInstance("MD5").digest(data);
        String checksum = new BigInteger(1, hash).toString(16);

        assertEquals("98f6bcd4621d373cade4e832627b4f6", checksum);

        boolean deleted = file.delete();
        assertEquals(Boolean.TRUE, deleted);
        Files.delete(testDir);
    }
}