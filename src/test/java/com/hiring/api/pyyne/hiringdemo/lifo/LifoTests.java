package com.hiring.api.pyyne.hiringdemo.lifo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.hiring.api.pyyne.hiringdemo.service.LifoService;

class LifoTests {

    LifoService lifoService;

    @BeforeEach
    void setUp() throws Exception {
        lifoService = new LifoService();
    }

    @Test
    @DisplayName("Adding to Stack")
    void testAddToStack() {
        String addReturn = lifoService.addToLifo("hello");
        assertEquals("hello", addReturn);
    }

    @Test
    @DisplayName("Popping Stack")
    void testPopStack() {
        lifoService.addToLifo("hello");
        String getReturn = lifoService.getLifo();
        assertEquals("hello", getReturn);
    }

    @Test
    @DisplayName("Popping Empty Stack")
    void testPopEmptyStack() {
        String getReturn = lifoService.getLifo();
        assertEquals(null, getReturn);
    }

}
