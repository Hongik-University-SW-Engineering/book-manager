package test;

import book.Book;
import book.BookManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTestDY {

    private BookManager bm;

    @BeforeEach
    public void 인스턴스생성() {
        bm = new BookManager();
    }

    @Test
    public void 테스트1() {
        // 책 추가 테스트
        bm.addBook(1, "자바 기초", "Jane", 2021);
        // 중복 id 테스트
        bm.addBook(1, "중복 책", "중복 책", 2021);

        // 책 검색 테스트
        bm.searchBook(1);
    }

    @Test
    public void 테스트2() {
        // 책 추가 테스트
        bm.addBook(1, "자바 기초", "Jane", 2021);
        bm.addBook(2, "소프트웨어 공학", "Tom", 2014);
        bm.addBook(3, "분산 컴퓨팅", "Yoon", 2024);

        // 책 검색 테스트
        Book book1 = bm.searchBook(1);
        Assertions.assertEquals(1, book1.getId());

        Book book2 = bm.searchBook(2);
        Assertions.assertEquals(2, book2.getId());

        Book book3 = bm.searchBook(3);
        Assertions.assertEquals(3, book3.getId());
    }

    @Test
    public void 테스트3() {
        // id 없이 검색 테스트
        bm.searchBook();

        bm.addBook(1, "자바 기초", "Jane", 2021);
        bm.addBook(2, "소프트웨어 공학", "Tom", 2014);

        // 책 삭제 테스트
        bm.removeBook(1);

        // 삭제한 책 검색 테스트
        bm.searchBook(1);

        bm.searchBook();
    }

    @Test
    public void 테스트4() {
        // 책 추가 테스트
        bm.addBook(1, "자바 기초", "Jane", 2021);

        // 중복 id 테스트
        bm.addBook(1, "중복 책", "중복 책", 2021);

        // 책 검색 테스트
        bm.searchBook(1);
    }

    @Test
    public void 테스트5() {
        // 책 추가 테스트
        bm.addBook(1, "자바 기초", "Jane", 2021);

        // 중복 id 테스트
        bm.addBook(1, "중복 책", "중복 책", 2021);

        // 책 검색 테스트
        bm.searchBook(1);
    }

    @Test
    public void search_bs_test() {
        bm.addBook(3, "The Bitcoin", "Satoshi Nakamoto", 2009);

        Book book = bm.search_bs(3);

        Assertions.assertEquals(3, book.getId());
    }

}