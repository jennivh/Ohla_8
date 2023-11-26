package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    private static TimeUtils time;
    @BeforeAll
    static void setUp(){
        time = new TimeUtils();
    }

    @ParameterizedTest(name="secToTime eri argumentilla {0}")
    @CsvSource({"3665, 1:01:05", "0, 0:00:00", ""+Integer.MAX_VALUE+", -1", "-50, -1", "60, 0:01:00",
    "3600, 1:00:00", "86400, 24:00:00", "1, 0:00:01","359999, 99:59:59", "360000, -1"})
    void secToTime(int secs, String expected) {
        assertEquals(expected, time.secToTime(secs));
    }
}