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

@Slf4j
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Hello Consumer!");

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String path = Utils.SHARED_MEMORY_PATH;
        int uuidSize = Utils.UUID_SIZE;
        int shaSize = Utils.SHA_SIZE;
        int size = Utils.TOTAL_SIZE;

        MappedByteBuffer sh = createSharedMemory(path, size);
        assert sh != null;
        log.info( "Capacity: {}", sh.capacity());

        byte[] uuidBytes = new byte[ uuidSize];
        byte[] shaBytes = new byte[ shaSize];

        int ok = 0;
        int errDisplayed = 0;
        int err = 0;

        while (true) {
            sh.get( 0, uuidBytes);
            sh.get( uuidSize, shaBytes);

            byte[] digest = md.digest(uuidBytes);
            if( MessageDigest.isEqual( digest, shaBytes)) {
                ok ++;
            } else {
                err ++;
            }

            if( err >= errDisplayed + 10) {
                errDisplayed = err;
                log.info( "Oks: {}, Errors: {}", ok, err);
            }

        }
    }

    private static MappedByteBuffer createSharedMemory(String path, long size) {
        try( FileChannel channel = (FileChannel) Files.newByteChannel( new File(path).toPath(),
                EnumSet.of(StandardOpenOption.CREATE,
                        StandardOpenOption.SPARSE,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ))) {
            return channel.map( FileChannel.MapMode.READ_WRITE, 0, size);
        }
        catch (IOException ex) {
            log.info( ex.getMessage());
        }

        return null;
    }
}