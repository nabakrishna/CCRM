package edu.ccrm.domain;

public class MaxCreditLimitExceededException extends Exception {
    public MaxCreditLimitExceededException(String message) {
        super(message);
    }

    public MaxCreditLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}