package pl.gatomek;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;

public class Utils {
    public static final String SHARED_MEMORY_PATH = "gatomek_ipc_shared_memory.dat";
    public static final int UUID_SIZE = 36;
    public static final int SHA_SIZE = 32;
    public static final int TOTAL_SIZE = UUID_SIZE + SHA_SIZE;


    public static long getBufferAddress(MappedByteBuffer mbb) {
        try {
            // However, be aware that, from Java 17 onwards, this technique won’t work unless we explicitly use the runtime –add-opens flag.

            Class<?> cls = mbb.getClass();
            Method address = cls.getMethod("address");
            address.setAccessible(true);
            Long addr = (Long) address.invoke(mbb);
            if( addr == null)
                throw new RuntimeException( "Unable to retrieve buffer's address");

            return addr;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}