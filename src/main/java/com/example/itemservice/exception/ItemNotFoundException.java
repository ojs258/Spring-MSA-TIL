package com.example.itemservice.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException() {
        super("상품을 찾을 수 없습니다.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
