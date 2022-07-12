package com.example.shortenurl.Service;


import com.example.shortenurl.Model.Base62;
import com.example.shortenurl.Model.ShortURL;
import com.example.shortenurl.Model.SnowFlakeID;
import com.example.shortenurl.Repository.ShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;

@Service
public class ShortURLServiceImpl implements ShortURLService{
    @Autowired
    private ShortURLRepository shortURLRepository;

    private SnowFlakeID sfService = new SnowFlakeID();
    @Override
    public String convertToShortURL(String longURL) {
        long sfID = this.sfService.newIdSequence();
        System.out.println(sfID);
        String sURL = Base62.to_Base62(sfID);
        ShortURL shortURLData = new ShortURL(sfID,sURL,longURL);
        shortURLRepository.save(shortURLData);
        return shortURLData.getShort62();
    }

    @Override
    public String convertToLongURL(String shortURL) {
        Long ID = Base62.to_Base10(shortURL);
        System.out.println(ID);
        String result = shortURLRepository.findById(ID).get().getLongURL();
        return result;
    }
}
