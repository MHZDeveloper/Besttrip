package com.test.besttrip.service;

public class IdService {



    public String generateId (String key){
        if(key == null || key.isEmpty()){
            throw new IllegalArgumentException("could not generate id from an empty key");
        }
        return key.replace(" ","-");
    }
}
