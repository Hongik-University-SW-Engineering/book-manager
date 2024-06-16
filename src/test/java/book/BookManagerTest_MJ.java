package book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BookManagerTest_MJ {

    private BookManager bm;

    @BeforeEach
    public void createInstance() {
        bm = new BookManager();
        System.out.println("CREATE TEST_INSTANCE");
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("Sequence of Testing is not be guaranteed\n");
        System.out.println("After TEST, CLEAN UP !");
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

        // when
        bm.addBook(1, "programming", "Kim", 2022);
        bm.addBook(3, "distributed computing", "Yoon", 2024);

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

    @Test
    public void test4() {
        // given
        System.out.println("TEST4 START!");
        bm.searchBook();

        // when
        bm.addBook(1, "C-Programming", "Bob", 1999);
        bm.addBook(2, "Operating System", "ALICE", 1999);
        bm.removeBook(1);

        // then
        bm.searchBook();
    }

}