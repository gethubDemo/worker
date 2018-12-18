package com.cuit.worker.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Message {
    private String msg;
    private int code;
    private Object data;
}
