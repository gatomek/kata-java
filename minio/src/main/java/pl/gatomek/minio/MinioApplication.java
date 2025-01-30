package pl.gatomek.minio;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class MinioApplication {

    public static void main(String[] args) throws
            ServerException,
            InsufficientDataException,
            ErrorResponseException,
            IOException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidResponseException,
            XmlParserException,
            InternalException {

        SpringApplication.run(MinioApplication.class, args);

        MinioClient minioClient = MinioClient.builder()
                        .endpoint("http://127.0.0.1:10000")
                        .credentials("minioadmin", "minioadmin")
                        .build();

        try (InputStream stream = minioClient.getObject(GetObjectArgs
                             .builder()
                             .bucket("tgl")
                             .object("minio.png")
                             .build())) {
            System.out.println( "success!");
        }
    }
}
