package pl.gatomek;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.EnumSet;
import java.util.UUID;

@Slf4j
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Hello Producer");

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String path = Utils.SHARED_MEMORY_PATH;
        int uuidSize = Utils.UUID_SIZE;
        int shaSize = Utils.SHA_SIZE;
        int size = Utils.TOTAL_SIZE;

        MappedByteBuffer sh = createSharedMemory(path, size);
        assert sh != null;
        log.info("Capacity: {}", sh.capacity());

        while (true) {
            byte[] uuidBytes = UUID.randomUUID().toString().getBytes();
            sh.put(0, uuidBytes);

            byte[] digest = md.digest(uuidBytes);
            sh.put(uuidSize, digest);
        }
    }

    private static MappedByteBuffer createSharedMemory(String path, long size) {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(new File(path).toPath(),
                EnumSet.of(StandardOpenOption.CREATE,
                        StandardOpenOption.SPARSE,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ))) {
            return channel.map(FileChannel.MapMode.READ_WRITE, 0, size);
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }

        return null;
    }
}
