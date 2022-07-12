package com.example.shortenurl.Repository;

import com.example.shortenurl.Model.ShortURL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLRepository extends MongoRepository <ShortURL, Long> {
    ShortURL findByShort62(String shortURL);
}
