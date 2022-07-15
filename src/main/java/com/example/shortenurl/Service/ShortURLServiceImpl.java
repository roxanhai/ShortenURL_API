package com.example.shortenurl.Service;


import com.example.shortenurl.Model.Base62;
import com.example.shortenurl.Model.ShortURL;
import com.example.shortenurl.Model.SnowFlakeID;
import com.example.shortenurl.Repository.ShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortURLServiceImpl implements ShortURLService{
    @Autowired
    private ShortURLRepository shortURLRepository;

    private SnowFlakeID sfService = new SnowFlakeID();
    @Override
    public ShortURL convertToShortURL(String longURL) {
        long sfID = this.sfService.newIdSequence();
        String sURL = "http://localhost:8080/"+ Base62.to_Base62(sfID);
        ShortURL shortURLData = new ShortURL(sfID,sURL,longURL);
        shortURLRepository.save(shortURLData);
        return shortURLData;
    }

    @Override
    public ShortURL convertToLongURL(String shortURL) {
        Long ID = Base62.to_Base10(shortURL);
        ShortURL shortURLData = shortURLRepository.findById(ID).get();
        return shortURLData;
    }
}
