package com.example.shortenurl.Service;

import com.example.shortenurl.Model.ShortURL;
import com.example.shortenurl.dto.LongUrlRequest;
import org.springframework.stereotype.Service;

@Service
public interface ShortURLService {
    public ShortURL convertToShortURL(LongUrlRequest longURL);
    public ShortURL convertToLongURL(String shortURL);
}