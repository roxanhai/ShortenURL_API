package com.example.shortenurl.Controller;

import com.example.shortenurl.Service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortURL")
public class ShortURLController {
    @Autowired
    private ShortURLService shortURLService;

    @PostMapping("")
    public ResponseEntity<?> toShortURL(@RequestParam String longURL){
        return ResponseEntity.ok(shortURLService.convertToShortURL(longURL));
    }

    @GetMapping("")
    public ResponseEntity<?> getLongURL(@RequestParam String shortURL){
        return ResponseEntity.ok(shortURLService.convertToLongURL(shortURL));
    }



}
