package com.example.tdd.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ExchangeMachine {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int EXTRACT_COUNT = 6;

    private Stack<Integer> lottoNumbers;

    public ExchangeMachine() {
        lottoNumbers = initNumbers();
        Collections.shuffle(lottoNumbers);
    }

    public List<Integer> inputToMachine(List<Integer> lottoPaper) {
        switch(lottoPaper.size()) {
            case 0:
                autoExtract(lottoPaper);
                break;
            case 6:
//                manualExtract(lottoPaper);
                break;
            default:
//                semiAutoExtract(lottoPaper);
                break;
        }
        return lottoPaper;
    }

    private void autoExtract(List<Integer> lottoPaper) {
        for (int i = 0; i < EXTRACT_COUNT; i++) {
            lottoPaper.add(lottoNumbers.pop());
        }
    }

    private Stack<Integer> initNumbers() {
        lottoNumbers = new Stack<>();

        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.push(i);
        }

        return lottoNumbers;
    }
}
