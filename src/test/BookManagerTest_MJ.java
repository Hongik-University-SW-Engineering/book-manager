package test;

import book.BookManager;
//import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest_MJ {

    private BookManager bm;

    @BeforeEach
    public void createInstance() {
        bm = new BookManager();
        System.out.println("CREATE TEST_INSTANCE");
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("Sequence of Testing is not be guaranteed\n");
    }

    @Test
    public void test1() {
        System.out.println("TEST1 START!");
        bm.searchBook(1);

        bm.addBook(1, "data structure", "Song", 2022);
        bm.addBook(1, "sw engineering", "Yoon", 2024);
        bm.addBook(1, "hello world", "Min", 2000);

        bm.searchBook(1);
    }

    @Test
    public void test2() {
        System.out.println("TEST2 START!");
        // given
        bm.addBook(1, "programming", "Kim", 2022);
        bm.addBook(3, "distributed computing", "Yoon", 2024);

        // when

        // then
        bm.searchBook(3);
        bm.searchBook();
    }

    @Test
    public void test3() {
        System.out.println("TEST3 START!");
        // given
        bm.searchBook();

        bm.addBook(1, "database", "Kim", 2023);
        bm.addBook(2, "blockchain", "Park", 2023);

        // then
        bm.removeBook(1);

        // then
        bm.searchBook(1);
        bm.searchBook(2);
    }

}