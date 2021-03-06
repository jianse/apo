package cn.ntboy.util;

public class ServiceFactoryException extends RuntimeException {

    public ServiceFactoryException() {
    }

    public ServiceFactoryException(String message) {
        super(message);
    }

    public ServiceFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceFactoryException(Throwable cause) {
        super(cause);
    }

    public ServiceFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
