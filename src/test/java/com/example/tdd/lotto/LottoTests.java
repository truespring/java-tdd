package com.example.tdd.lotto;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LottoTests {
    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto();
    }

    @Test
    public void 번호가_입력되는가() throws NoSuchFieldException, IllegalAccessException {
        Field lottoPaper = lotto.getClass().getDeclaredField("lottoPaper");

        lottoPaper.setAccessible(true);

        lotto.writeNumber(new Scanner("1,2"));

        List<Integer> numbers = (List<Integer>) lottoPaper.get(lotto);

        assertEquals(false, numbers.isEmpty());
    }

    @Test
    public void 입력이_없을때_처리되는가() throws NoSuchFieldException, IllegalAccessException {
        Field lottoPaper = lotto.getClass().getDeclaredField("lottoPaper");

        lottoPaper.setAccessible(true);

        lotto.writeNumber(new Scanner(""));

        List<Integer> numbers = (List<Integer>) lottoPaper.get(lotto);

        assertEquals(true, numbers.isEmpty());
    }
}
