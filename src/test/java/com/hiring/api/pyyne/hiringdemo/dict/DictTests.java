package com.hiring.api.pyyne.hiringdemo.dict;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.hiring.api.pyyne.hiringdemo.controller.DictController;
import com.hiring.api.pyyne.hiringdemo.service.DictService;

/* src: https://ricardolsmendes.medium.com/cleaning-up-spring-boot-integration-tests-logs-5b2d0a5f29bc
* Potential stuff to add here
* */
@ContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
class DictTests {

    @Autowired
    DictService dictService;

    @Autowired
    DictController dictController;

    // @BeforeEach
    // void setUp() throws Exception {
    // dictService = new DictService();
    // dictController = new DictController(dictService);
    // }

    // ChatGPT idea: void testGet() throws InterruptedException {
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

    @Test
    @DisplayName("Adding to Dict Controller Layer no TTL")
    void testAddToDictControllerNoTTL() {
        String addReturn = dictController.addToDict("name", "john", 0);
        assertEquals("Added: name = john without ttl", addReturn);
    }

    @Test
    @DisplayName("Adding to Dict Controler Layer with TTL")
    void testAddToDictControllerWithTTL() {
        String addReturn = dictController.addToDict("name", "larry", 3);
        assertEquals("Added: name = larry with ttl 3 seconds", addReturn);
    }

    /* GET */

    @Test
    @DisplayName("Get from Dict Service Layer with TTL")
    void testGetFromDictServiceWithTTL() {
        dictService.addToDict("name", "larry", 3);
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

    @Test
    @DisplayName("Get from Dict Controller Layer with TTL")
    void testGetFromDictControllerWithTTL() {
        dictController.addToDict("name", "larry", 3);
        String getReturn = dictController.getDict("name");
        assertEquals("larry", getReturn);
    }

    @Test
    @DisplayName("Get from Dict Controller Layer with TTL")
    void testGetFromDictControllerNoTTL() {
        dictController.addToDict("name", "larry", 0);
        String getReturn = dictController.getDict("name");
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
        assertEquals("Not found: name", getReturn);
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
        assertEquals("Not found: name", getReturn);
    }

    @Test
    @DisplayName("Get from Dict Controller Layer with TTL")
    void testDeleteFromDictControllerWithTTL() {
        dictController.addToDict("name", "larry", 3);
        String getReturn = dictController.getDict("name");
        assertEquals("larry", getReturn);
        String deleteReturn = dictController.deleteFromDict("name");
        assertEquals("Removed: name", deleteReturn);
        getReturn = dictController.getDict("name");
        assertEquals("Not found: name", getReturn);
    }

    @Test
    @DisplayName("Get from Dict Controller Layer with TTL")
    void testDeleteFromDictControllerNoTTL() {
        dictController.addToDict("name", "larry", 0);
        String getReturn = dictController.getDict("name");
        assertEquals("larry", getReturn);
        String deleteReturn = dictController.deleteFromDict("name");
        assertEquals("Removed: name", deleteReturn);
        getReturn = dictController.getDict("name");
        assertEquals("Not found: name", getReturn);
    }
}
