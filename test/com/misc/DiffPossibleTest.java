package com.misc;

import org.junit.Assert;
import org.junit.Test;

public class DiffPossibleTest {
    @Test
    public void test(){
        String s = "97 66 37 46 56 49 65 62 21 7 70 13 71 93 26 18 84 96 65 92 69 97 47 6 18 17 47 28 71 70 24 46 58 71 21 30 44 78 31 45 65 16 3 22 54 51 68 19 86 44 99 53 24 40 92 38 81 4 96 1 13 45 76 77 8 88 50 89 38 60 61 49 25 10 80 49 63 95 74 29 27 52 27 40 66 38 22 85 22 91 98 19 20 78 77 48 63 27";
        Assert.assertEquals(1, DiffPossible.test(s, 31));
    }
}