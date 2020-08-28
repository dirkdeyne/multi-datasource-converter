package com.example.demo.bar;

import com.example.demo.converters.StringEncryptDecryptConverter;

import javax.persistence.*;

@Entity
public class Bar {
    @Id
    private Long id;
    private String name;
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String secret;

    /* only for JPA */ Bar(){}

    public Bar(Long id, String name, String secret) {
        this.id = id;
        this.name = name;
        this.secret = secret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                '}';
    }
}
