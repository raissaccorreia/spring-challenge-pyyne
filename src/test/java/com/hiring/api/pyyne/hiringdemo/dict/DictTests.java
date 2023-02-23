package com.hiring.api.pyyne.hiringdemo.dict;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.hiring.api.pyyne.hiringdemo.service.DictService;

class DictTests {

    DictService dictService;

     @BeforeEach
     void setUp() throws Exception {
         dictService = new DictService();
     }

    // TimeUnit.SECONDS.sleep(3);

    /* ADD */
    @Test
    @DisplayName("Adding to Dict Service Layer no TTL")
    void testAddToDictServiceNoTTL() {
        String addReturn = dictService.addToDict("name", "john", 0);
        assertEquals("Added: name = john without ttl", addReturn);
    }

    @Test
    @DisplayName("Adding to Dict Service Layer with TTL")
    void testAddToDictServiceWithTTL() {
        String addReturn = dictService.addToDict("name", "larry", 3);
        assertEquals("Added: name = larry with ttl 3 seconds", addReturn);
    }

    /* GET */

    @Test
    @DisplayName("Get from Dict Service Layer with TTL")
    void testGetFromDictServiceWithTTL() {
        dictService.addToDict("name", "larry", 1);
        String getReturn = dictService.getDict("name");
        assertEquals("larry", getReturn);
    }

    @Test
    @DisplayName("Get from Dict Service Layer without TTL")
    void testGetFromDictServiceNoTTL() {
        dictService.addToDict("name", "larry", 0);
        String getReturn = dictService.getDict("name");
        assertEquals("larry", getReturn);
    }

    /* DELETE */

    @Test
    @DisplayName("Get from Dict Service Layer with TTL")
    void testDeleteFromDictServiceWithTTL() {
        dictService.addToDict("name", "larry", 3);
        String getReturn = dictService.getDict("name");
        assertEquals("larry", getReturn);
        String deleteReturn = dictService.deleteFromDict("name");
        assertEquals("Removed: name", deleteReturn);
        getReturn = dictService.getDict("name");
        assertEquals(null, getReturn);
    }

    @Test
    @DisplayName("Get from Dict Service Layer without TTL")
    void testDeleteFromDictServiceNoTTL() {
        dictService.addToDict("name", "larry", 0);
        String getReturn = dictService.getDict("name");
        assertEquals("larry", getReturn);
        String deleteReturn = dictService.deleteFromDict("name");
        assertEquals("Removed: name", deleteReturn);
        getReturn = dictService.getDict("name");
        assertEquals(null, getReturn);
    }
}
