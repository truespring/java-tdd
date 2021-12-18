package com.example.tdd.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExchangeMachineTests {
    private ExchangeMachine exchangeMachine;

    private List<Integer> lottoPaper;

    @Before
    public void setUp() {
        lottoPaper = new ArrayList<>();
    }

    @Test
    public void 리스트사이즈가_0일때_자동으로_6개숫자_추출되는가() {
        ExchangeMachine exchangeMachine = new ExchangeMachine();

        exchangeMachine.inputToMachine(lottoPaper);

        assertEquals(6, lottoPaper.size());
    }

}
