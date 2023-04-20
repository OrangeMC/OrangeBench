package moe.orangemc.orangebench.util;

public final class SneakyExceptionThrower {
    private SneakyExceptionThrower() {
        throw new UnsupportedOperationException();
    }
    // Dirty hack of checked exception. Only for tidying code.
    @SuppressWarnings("unchecked")
    public static  <T extends Throwable> void throwException(Throwable exc) throws T {
        throw (T)exc;
    }
}
