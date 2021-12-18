package com.example.tdd.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Extractor {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int EXTRACT_COUNT = 6;

    private final Stack<Integer> balls;

    public Extractor() {
        balls = new Stack<>();
        Collections.shuffle(readyMachine());
    }

    private Stack<Integer> readyMachine() {
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            balls.push(i);
        }

        return balls;
    }

    public List<Integer> extractBall() {
        List<Integer> extractedBalls = new ArrayList<>();

        for (int i = 0; i < EXTRACT_COUNT; i++) {
            extractedBalls.add(balls.pop());
        }

        return extractedBalls;
    }
}
