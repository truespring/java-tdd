package com.example.tdd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    private List<Integer> lottoPaper;

    public Lotto() {
    }

    public void writeNumber(Scanner sc) {
        lottoPaper = new ArrayList<>();
        String lottoStr = toString(sc);

        if (lottoStr == null || lottoStr.isEmpty()) {
            return;
        }

        toInts(toStrArr(lottoStr));
    }

    public List<Integer> getLottoPaper() {
        System.out.println(readPaper());
        return lottoPaper;
    }

    private String toString(Scanner sc) {
        if (!sc.hasNext()) return "";
        return sc.nextLine();
    }

    private String readPaper() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lottoPaper.size(); i++) {
            sb.append(lottoPaper.get(i));

            if (i != lottoPaper.size() - 1) {
                sb.append("\t");
            }
        }

        return sb.toString();
    }

    private String[] toStrArr(String lottoStr) {

        return lottoStr.split("[,:]");
    }

    private void toInts(String[] strArr) {
        for (String str : strArr) {
            lottoPaper.add(Integer.parseInt(str));
        }
    }
}
