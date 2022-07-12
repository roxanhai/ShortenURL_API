package com.example.shortenurl.Service;

import org.springframework.stereotype.Service;

@Service
public interface ShortURLService {
    public String convertToShortURL(String longURL);
    public String convertToLongURL(String shortURL);
}