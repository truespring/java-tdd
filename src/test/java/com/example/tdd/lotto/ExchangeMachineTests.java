package com.example.tdd.lotto;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ExchangeMachineTests {
    private ExchangeMachine exchangeMachine;

    private List<Integer> lottoPaper;

    @Before
    public void setUp() {
        lottoPaper = new ArrayList<>();
        exchangeMachine = new ExchangeMachine();
    }

    @Test
    public void 리스트사이즈가_0일때_자동으로_6개숫자_추출되는가() {
        exchangeMachine.inputToMachine(lottoPaper);

        assertEquals(6, lottoPaper.size());
    }

    @Test
    public void 원하는_값_제거() throws NoSuchFieldException, IllegalAccessException {
        Field lottoNumbers = exchangeMachine.getClass().getDeclaredField("lottoNumbers");

        lottoNumbers.setAccessible(true);

        Stack<Integer> resultNumbers = (Stack<Integer>) lottoNumbers.get(exchangeMachine);

        lottoPaper.add(1);

        assertEquals(1, lottoPaper.size());
        assertEquals(0, resultNumbers.size());

        exchangeMachine.inputToMachine(lottoPaper);

        assertEquals(-1, resultNumbers.indexOf(1));
        assertEquals(45 - 6, resultNumbers.size());
        assertEquals(6, lottoPaper.size());
    }

    @Test
    public void 리스트사이즈가_1에서_5사이일때_반자동으로_6개숫자_완성되는가() {
        lottoPaper.add(1);

        assertEquals(1, lottoPaper.size());

        exchangeMachine.inputToMachine(lottoPaper);

        assertEquals(6, lottoPaper.size());
    }

    @Test
    public void Stack_remove_되는지() {
        Stack<Integer> numbers = new Stack<>();

        for (int i = 1; i <= 45; i++) {
            numbers.push(i);
        }

        Collections.shuffle(numbers);

        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (Integer integer : list) {
            numbers.removeElement(integer);
        }

        assertEquals(44, numbers.size());
    }

    @Test
    public void 숫자가_6초과일때_처리되는가() throws NoSuchFieldException, IllegalAccessException {
        Field isCountCheck = exchangeMachine.getClass().getDeclaredField("isCountCheck");

        isCountCheck.setAccessible(true);

        for (int i = 0; i < 8; i++) {
            lottoPaper.add(i);
        }

        exchangeMachine.inputToMachine(lottoPaper);

        boolean resultBoolean = (Boolean) isCountCheck.get(exchangeMachine);

        assertEquals(false, resultBoolean);
    }
}
