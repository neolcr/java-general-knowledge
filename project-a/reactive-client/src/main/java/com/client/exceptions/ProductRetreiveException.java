package com.client.exceptions;

public class ProductRetreiveException extends RuntimeException{
    public ProductRetreiveException(String message){
        super("ProductRetreiveException: " + message);
    }
}
