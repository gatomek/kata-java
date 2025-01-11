package pl.gatomek;

import sun.misc.Unsafe;

public class IpcSpinLock {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private final long addr;

    public IpcSpinLock(long addr) {
        this.addr = addr;
    }

    public boolean tryLock( long maxWait) {
        long deadline = System.currentTimeMillis() + maxWait;
        while( System.currentTimeMillis() < deadline) {
            if( unsafe.compareAndSwapInt( null, addr, 0, 1)) {
                return true;
            }
        }
        return false;
    }

    public void unlock() {
        unsafe.putInt( addr, 0);
    }
}
