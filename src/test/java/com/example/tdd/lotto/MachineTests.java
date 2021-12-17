package com.example.tdd.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Stack;

public class MachineTests {
    private Machine machine;

    @BeforeEach
    public void setUp() {
        machine = new Machine();
    }

    @Test
    public void 마흔다섯개의_번호가_생성되는가() throws NoSuchFieldException, IllegalAccessException {
        Field balls = machine.getClass().getDeclaredField("balls");

        balls.setAccessible(true);

        Stack<Integer> resultBalls = (Stack<Integer>) balls.get(machine);

        Assertions.assertEquals(45, resultBalls.size());
    }

    @Test
    public void 숫자공이_추출되는가() {
        Integer ball = machine.extractBall();

        Assertions.assertTrue(Objects.nonNull(ball));
    }
}
