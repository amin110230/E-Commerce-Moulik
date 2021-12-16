package net.moulik.ecommercemoulik.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Throwable cause) {
        super(cause.getMessage());
    }
}
