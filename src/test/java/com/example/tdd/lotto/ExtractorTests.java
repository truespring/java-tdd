package com.example.tdd.lotto;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Stack;

import static junit.framework.TestCase.assertEquals;


public class ExtractorTests {
    private Extractor machine;

    @Before
    public void setUp() {
        machine = new Extractor();
    }

    @Test
    public void 마흔다섯개의_번호가_생성되는가() throws NoSuchFieldException, IllegalAccessException {
        Field balls = machine.getClass().getDeclaredField("balls");

        balls.setAccessible(true);

        Stack<Integer> resultBalls = (Stack<Integer>) balls.get(machine);

        assertEquals(45, resultBalls.size());
    }

    @Test
    public void 여섯개의_공이_뽑아지는가() {
        List<Integer> extractedBalls = machine.extractBall();

        assertEquals(6, extractedBalls.size());
    }
}
