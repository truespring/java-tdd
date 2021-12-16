package com.example.tdd.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Release {
    private static final int LOTTO_NUMBER = 45;
    private static final int SELECT_COUNT = 6;

    private List<Lotto> lottos;
    private Stack<Lotto> lottoNumber;

    public Release() {
        lottos = new ArrayList<>();
        setLottoNumber();
        Collections.shuffle(lottoNumber);
    }

    private void setLottoNumber() {
        lottoNumber = new Stack<>();
        for (int i = 1; i <= LOTTO_NUMBER; i++) {
            lottoNumber.add(new Lotto(i));
        }
    }

    public void getLottoNumber() {
        for (int i = 0; i < SELECT_COUNT; i++) {
            lottos.add(lottoNumber.pop());
        }
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::intToString).collect(Collectors.joining(", "));
    }
}
