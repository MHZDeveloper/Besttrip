package com.test.besttrip.model;

import java.util.stream.Stream;

public enum RankNumber {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);


    private int value;

    RankNumber(int number){
        value=number;
    }

    public static RankNumber getFromValue(int value){
        return Stream.of(RankNumber.values())
                .filter(number -> number.getValue()==value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid" +value));
    }

    public int getValue(){
        return value;
    }
}
