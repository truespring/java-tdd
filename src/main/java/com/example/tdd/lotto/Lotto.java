package com.example.tdd.lotto;

public class Lotto {

    private int selectNumber;

    public Lotto(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public String intToString() {
        return String.valueOf(selectNumber);
    }
}
