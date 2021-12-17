package com.example.tdd.lotto;

import java.util.Collections;
import java.util.Stack;

public class Machine {
    private static final int LOTTO_MAX_NUMBER = 45;

    private Stack<Integer> balls;

    public Machine() {
        balls = new Stack<>();
        Collections.shuffle(readyMachine());
    }

    private Stack<Integer> readyMachine() {
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            balls.push(i);
        }
        return balls;
    }

    public Integer extractBall() {
        return balls.pop();
    }
}
