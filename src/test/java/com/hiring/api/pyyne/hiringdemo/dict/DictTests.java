package com.hiring.api.pyyne.hiringdemo.dict;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.hiring.api.pyyne.hiringdemo.service.DictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@SpringBootTest
class DictTests {

    DictService dictService;

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

    @BeforeEach
    void setUp() {
        dictService = new DictService();
    }

    @Test
    @DisplayName("Just like the PDF")
    void test1() {
        String addReturn = dictService.addToDict("name", "john", 0);
        String getReturn = dictService.getDict("name");
        assertEquals("Added: name = john without ttl", addReturn);
        assertEquals("john", getReturn);
        String ageReturn = dictService.getDict("age");
        assertEquals("Not found: age", ageReturn);
        addReturn = dictService.addToDict("name", "larry", 3);
        getReturn = dictService.getDict("name");
        assertEquals("Added: name = larry with ttl 3 seconds", addReturn);
        assertEquals("larry", getReturn);
        getReturn = dictService.getDict("name");
        assertEquals("larry", getReturn);
    }
}
