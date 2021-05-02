package com.spring.mail.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {

    private String header;

    private String text;

    private String to;
}
