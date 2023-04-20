package moe.orangemc.orangebench.storage.file.io;

import moe.orangemc.orangebench.storage.file.io.impl.SilentFileDataInputStreamImpl;
import moe.orangemc.orangebench.storage.file.io.impl.SilentFileDataOutputStreamImpl;
import moe.orangemc.orangebench.util.SneakyExceptionThrower;
import org.jetbrains.annotations.Contract;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Cleaner;

public class FileDataStreams {
    private static final Cleaner cleaner = Cleaner.create();

    public static SilentFileDataInputStream createInputStream(File target) {
        SilentFileDataInputStreamImpl result = new SilentFileDataInputStreamImpl(target);
        InputStream is = result.getNativeStream();
        cleaner.register(result, () -> {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    SneakyExceptionThrower.throwException(e);
                }
            }
        });
        return result;
    }

    public static SilentFileDataOutputStream createOutputStream(File target) {
        SilentFileDataOutputStreamImpl result = new SilentFileDataOutputStreamImpl(target);
        OutputStream os = result.getNativeStream();
        cleaner.register(result, () -> {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    SneakyExceptionThrower.throwException(e);
                }
            }
        });
        return result;
    }
}
