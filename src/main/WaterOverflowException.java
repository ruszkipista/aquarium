package main;

public class WaterOverflowException extends RuntimeException {
    public WaterOverflowException(String errorMessage) {
        super(errorMessage);
    }
}