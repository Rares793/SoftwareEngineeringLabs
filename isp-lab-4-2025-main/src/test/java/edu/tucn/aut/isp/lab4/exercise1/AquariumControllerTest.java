package edu.tucn.aut.isp.lab4.exercise1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AquariumControllerTest {
    //implement minimal tests
    @Test
    void dummyTestNPE() {
        Assertions.assertThrows(
                NullPointerException.class, () -> {Integer nullInt = null; nullInt.toString();});
    }
}
