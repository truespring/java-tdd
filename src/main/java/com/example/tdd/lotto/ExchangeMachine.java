package com.example.tdd.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ExchangeMachine {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int EXTRACT_COUNT = 6;

    private Stack<Integer> lottoNumbers;
    private boolean isCountCheck;

    public ExchangeMachine() {
        lottoNumbers = new Stack<>();
    }

    public void inputToMachine(List<Integer> lottoPaper) {
        if (!validationCheck(lottoPaper)) {
            System.out.println("6개 이하의 수를 입력하세요");
            isCountCheck = false;
            return;
        }

        lottoNumbers = initNumbers();
        Collections.shuffle(lottoNumbers);

        fillNumber(lottoPaper);

        isCountCheck = true;
    }

    private void fillNumber(List<Integer> lottoPaper) {
        switch (lottoPaper.size()) {
            case 0:
                autoExtract(lottoPaper);
                break;
            case 6:
                break;
            default:
                removeDuplicate(lottoPaper);
                semiAutoExtract(lottoPaper);
                break;
        }
    }

    private void autoExtract(List<Integer> lottoPaper) {
        for (int i = 0; i < EXTRACT_COUNT; i++) {
            lottoPaper.add(lottoNumbers.pop());
        }
    }

    private void semiAutoExtract(List<Integer> lottoPaper) {
        int count = EXTRACT_COUNT - lottoPaper.size();

        for (int i = 0; i < count; i++) {
            lottoPaper.add(lottoNumbers.pop());
        }
    }

    private void removeDuplicate(List<Integer> lottoPaper) {
        for (Integer integer : lottoPaper) {
            lottoNumbers.removeElement(integer);
        }
    }

    private Stack<Integer> initNumbers() {
        lottoNumbers.clear();

        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.push(i);
        }

        return lottoNumbers;
    }

    private boolean validationCheck(List<Integer> lottoPaper) {
        return lottoPaper.size() <= 6;
    }
}
