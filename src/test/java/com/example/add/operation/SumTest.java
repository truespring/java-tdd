package com.example.add.operation;

import org.junit.Test;

public class SumTest {

    @Test(expected = RuntimeException.class)
    public void 음수값() {
        Sum.splitAndSum2("-1,2:3");
    }
}
