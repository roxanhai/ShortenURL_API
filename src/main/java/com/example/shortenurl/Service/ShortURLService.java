package com.example.shortenurl.Service;

import com.example.shortenurl.Model.ShortURL;
import org.springframework.stereotype.Service;

@Service
public interface ShortURLService {
    public ShortURL convertToShortURL(String longURL);
    public ShortURL convertToLongURL(String shortURL);
}