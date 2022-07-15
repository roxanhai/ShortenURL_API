package com.example.shortenurl.Controller;

import com.example.shortenurl.Model.ShortURL;
import com.example.shortenurl.Service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("")
public class ShortURLController {
    @Autowired
    private ShortURLService shortURLService;

    @PostMapping("/shortURL")
    public ResponseEntity<?> toShortURL(@RequestParam String longURL){
        return ResponseEntity.ok(shortURLService.convertToShortURL(longURL));
    }

    @GetMapping("/{sURL}")
    public RedirectView getLongURL(@PathVariable(value="sURL") String sURL){
        RedirectView redirectView = new RedirectView();
        ShortURL shortURLData = shortURLService.convertToLongURL(sURL);
        redirectView.setUrl(shortURLData.getLongURL());
        return redirectView;
    }



}
