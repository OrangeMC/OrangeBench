package moe.orangemc.orangebench.storage.file.io;

import java.util.UUID;

public interface SilentFileDataInputStream {
    int readInt();
    long readLong();
    UUID readUUID();
    String readString();
    double readDouble();
    float readFloat();
    boolean readBoolean();
}
