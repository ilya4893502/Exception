package com.example.springapp81.util;

public class PersonErrorResponse {

    // В этом классе мы опишем те поля, которые будут отправляться при ошибке.
    // У нас будет сообщение об ошибке и отметка в миллисекундах, в которой произошла ошибка.

    private String message;
    private long timestamp;

    public PersonErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
