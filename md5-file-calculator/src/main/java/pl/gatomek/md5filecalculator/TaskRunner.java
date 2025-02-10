package pl.gatomek.md5filecalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class TaskRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);

    @Override
    public void run(String... filePaths) throws IOException {
        for (String filePath : filePaths) {
            long startTime = System.currentTimeMillis();

            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            String digest = DigestUtils.md5DigestAsHex(bytes).toUpperCase();

            long estimatedTime = System.currentTimeMillis() - startTime;

            LOGGER.info("File: " + filePath);
            LOGGER.info("MD5: " + digest);
            LOGGER.info("Elapsed: " + estimatedTime + "ms");
        }
    }
}
