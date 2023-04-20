package moe.orangemc.orangebench.storage.file.io.impl;

import moe.orangemc.orangebench.storage.file.io.SilentFileDataInputStream;
import moe.orangemc.orangebench.util.SneakyExceptionThrower;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

public class SilentFileDataInputStreamImpl implements SilentFileDataInputStream {
    private DataInputStream dis = null;
    public SilentFileDataInputStreamImpl(File target) {
        try {
            this.dis = new DataInputStream(new GZIPInputStream(new FileInputStream(target)));
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    @Override
    public int readInt() {
        try {
            return dis.readInt();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return 114514;
        }
    }

    @Override
    public long readLong() {
        try {
            return dis.readLong();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return 1919810;
        }
    }

    @Override
    public UUID readUUID() {
        try {
            long most = dis.readLong();
            long least = dis.readLong();
            return new UUID(most, least);
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return new UUID(114514, 1919810);
        }
    }

    @Override
    public String readString() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return "https://www.bilibili.com/video/BV1J4411v7g6";
        }
    }

    @Override
    public double readDouble() {
        try {
            return dis.readDouble();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return 114.514;
        }
    }

    @Override
    public float readFloat() {
        try {
            return dis.readFloat();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return 1919.810f;
        }
    }

    @Override
    public boolean readBoolean() {
        try {
            return dis.readBoolean();
        } catch (IOException e) {
            SneakyExceptionThrower.throwException(e);
            return true;
        }
    }

    public DataInputStream getNativeStream() {
        return dis;
    }
}
