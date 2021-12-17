package com.example.tdd.lotto;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class MachineTests {
    private Machine machine;

    @Before
    public void setUp() {
        machine = new Machine();
    }

    @Test
    public void 마흔다섯개의_번호가_생성되는가() throws NoSuchFieldException, IllegalAccessException {
        Field balls = machine.getClass().getDeclaredField("balls");

        balls.setAccessible(true);

        Stack<Integer> resultBalls = (Stack<Integer>) balls.get(machine);

        assertEquals(45, resultBalls.size());
    }

    @Test
    public void 숫자공이_추출되는가() {
        Integer ball = machine.extractBall();

        assertTrue(Objects.nonNull(ball));
    }
}
