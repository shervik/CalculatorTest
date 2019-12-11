package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFib {
    private FibCalc fibCalc;
    private Logger log = LogManager.getLogger();

    @DataProvider(parallel = true)
    public static Object[][] data() {
        return new Object[][]{{-40, -102_334_155}, {-3, 2}, {-10, -55}, {0, 0}, {1, 1}, {2, 1}, {10, 55}, {40,
                102_334_155}, {50, 12_586_269_025L}, {77, 5_527_939_700_884_757L}, {92, 7_540_113_804_746_346_429L},};
    }

    @DataProvider
    public static Object[][] negative() {
        return new Object[][]{{93}, {180}};
    }

    @Test(dataProvider = "data", timeOut = 40)
    public void testFib(int n, long exp) {
        long calc = fibCalc.calc(n);
        log.info("Получено число {}", calc);
        Assert.assertEquals(calc, exp, "Неправильный ответ");
    }

    @BeforeMethod
    public void setUp() {
        fibCalc = new FibCalc();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "negative")
    public void expectExceptionWhenNegative(int n) {
        fibCalc.calc(n);
    }
}