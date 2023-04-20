package moe.orangemc.orangebench.storage.file.io.impl;

import moe.orangemc.orangebench.storage.file.io.SilentFileDataOutputStream;
import moe.orangemc.orangebench.util.SneakyExceptionThrower;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

public class SilentFileDataOutputStreamImpl implements SilentFileDataOutputStream {
    private DataOutputStream dos = null;

    public SilentFileDataOutputStreamImpl(File targetFile) {
        try {
            dos = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(targetFile)));
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeInt(int i) {
        try {
            dos.writeInt(i);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeLong(long l) {
        try {
            dos.writeLong(l);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeUUID(UUID uuid) {
        try {
            dos.writeLong(uuid.getMostSignificantBits());
            dos.writeLong(uuid.getLeastSignificantBits());
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeString(String s) {
        try {
            dos.writeUTF(s);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeDouble(double d) {
        try {
            dos.writeDouble(d);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeFloat(float f) {
        try {
            dos.writeFloat(f);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public void writeBoolean(boolean b) {
        try {
            dos.writeBoolean(b);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    public DataOutputStream getNativeStream() {
        return dos;
    }
}
