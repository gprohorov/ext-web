package edu.se.extweb;

import edu.se.extweb.model.Item;
import edu.se.extweb.request.ItemPageRequest;
import edu.se.extweb.response.ApiResponse;
import edu.se.extweb.response.BaseMetaData;
import edu.se.extweb.response.PaginationMetaData;
import edu.se.extweb.service.ItemService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemServicePagingTest {


    @Autowired
    private ItemService underTest;

    List<Item> items = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
    }
   @AfterEach
    void tearsDown(){
    }

    @Test
    void whenHappyPathThenOk(){
        // given
        ItemPageRequest request = new ItemPageRequest(0,5);
        // when
            ApiResponse<PaginationMetaData, Item> response = underTest.getItemsPage(request);
        //then
         assertNotNull(response);
         assertNotNull(response.getMeta());

         assertEquals(200, response.getMeta().getCode());
         assertTrue(response.getMeta().isSuccess());
         assertNull(response.getMeta().getErrorMessage());

         assertEquals(0, response.getMeta().getNumber());
         assertEquals(5, response.getMeta().getSize());
         assertEquals(30, response.getMeta().getTotalElements());
         assertEquals(6, response.getMeta().getTotalPages());
         assertTrue(response.getMeta().isFirst());
         assertFalse(response.getMeta().isLast());

         assertNotNull(response.getData());
         assertFalse(response.getData().isEmpty());
         assertEquals(5, response.getData().size());
         assertEquals("69aeefcbe5c3dbd26376b0c5", response.getData().get(0).getId());
    }

    @Test
    void whenSizeIs_7_AndPageIs_4_ThenIsLast_TrueAndSizeEquals_2(){
        // your code
    }


    @Test
    void whenTheListIsEmptyThenErrorMessageHasTheWarning(){
        // your code
    }

    @Test
    void whenTheListIsEmptyThenMetadataAndDataAreNotNull(){
        // your code
    }


    @Test
    void whenPageValueIsOutOfRangeThenErrorMessageHasTheWarning(){
        // your code
    }

}
