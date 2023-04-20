package moe.orangemc.orangebench.storage.file.io;

import java.util.UUID;

public interface SilentFileDataOutputStream {
    void writeInt(int i);
    void writeLong(long l);
    void writeUUID(UUID uuid);
    void writeString(String s);
    void writeDouble(double d);
    void writeFloat(float f);
    void writeBoolean(boolean b);
}
