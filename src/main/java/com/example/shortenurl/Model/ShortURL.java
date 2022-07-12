package com.example.shortenurl.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


import java.io.Serializable;

@Getter
@Setter
@ToString

@Document(collection="sURL")
public class ShortURL implements Serializable {
    @Id
    private long id;
    private String short62;
    private String longURL;

    public ShortURL() {
    }

    public ShortURL(long id, String short62, String longURL) {
        this.id = id;
        this.short62 = short62;
        this.longURL = longURL;
    }

    public ShortURL(String short62, String longURL) {
        this.short62 = short62;
        this.longURL = longURL;
    }
}

