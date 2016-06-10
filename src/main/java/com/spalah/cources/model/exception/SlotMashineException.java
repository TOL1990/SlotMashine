package com.spalah.cources.model.exception;

/**
 * Created by Тарас on 09.06.2016.
 */
public class SlotMashineException extends Exception {
    public SlotMashineException() {
    }

    public SlotMashineException(String message) {
        super(message);
    }

    public SlotMashineException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlotMashineException(Throwable cause) {
        super(cause);
    }

    public SlotMashineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

