package edu.se.extweb;

import edu.se.extweb.model.Item;
import edu.se.extweb.request.ItemCreateRequest;
import edu.se.extweb.service.ItemService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemServiceTest {


    @Autowired
    private ItemService underTest;

    List<Item> items = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {

      //  underTest.createAll(items);
    }

    @BeforeEach
    void setUp() {
        underTest.createAll(items);

    }
   @AfterEach
    void tearsDown(){
        underTest.deleteAll();
    }

    @Test
    void whenInsertNewItem_ThenCreateDateIsPresent() {
        //given


    }

    @Test
    void update() {
    }
}
