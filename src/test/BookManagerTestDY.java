package test;

import book.BookManager;
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
        bm.searchBook(1);
        bm.searchBook(2);
        bm.searchBook(3);
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

}