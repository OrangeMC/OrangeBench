package moe.orangemc.orangebench.util;

import moe.orangemc.orangebench.OrangeBenchPlugin;
import net.kyori.adventure.key.Key;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class IdGenerator {
    private final Map<Integer, Object> usedIds = new ConcurrentHashMap<>();

    public int generateModelId(Key key) {
        int namespaceHash = processHash(key.namespace().hashCode());
        int keyHash = processHash(key.key().hashCode());

        int finalHash = (namespaceHash << 12 | keyHash);
        while (usedIds.containsKey(finalHash)) {
            if ((++finalHash) >>> 12 != namespaceHash) { // Namespace hash cannot be damaged since it might be used by every plugin.
                throw new IndexOutOfBoundsException("We are out of available ids.");
            }
        }

        usedIds.put(finalHash, new Object());
        return finalHash;
    }

    private int processHash(int hash) {
        int segment1 = hash & 0x00000fff;
        int segment2 = hash & 0x00fff000;
        int segment3 = hash & 0xff000000;

        return segment1 ^ (segment2 >>> 12) ^ (segment3 >>> 24);
    }

    public void addUsedId(int id) {
        Validate.isTrue((id & 0xff000000) != 0, "Id overflow.");
        usedIds.put(id, new Object());
    }
}
