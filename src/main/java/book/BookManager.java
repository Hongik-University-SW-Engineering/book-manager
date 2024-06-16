package book;

import java.util.*;

/**
 * 도서 관리 클래스
 * Book management class
 */
public class BookManager {

    /**
     * 도서 목록
     * Book list
     */
    private final List<Book> books = new ArrayList<>();

    /**
     * 도서 목록에 책 추가.
     * 이미 존재하는 ID인 경우, 해당 ID가 이미 존재한다는 메시지 출력.
     * Add a book to the book list.
     * If the ID already exists, print a message that the ID already exists.
     *
     * @param id      책 ID / Book ID
     * @param name    책 이름 / Book name
     * @param author  저자 / Author
     * @param publish 출판년도 / Publish year
     * @return 새로 추가된 책 객체, null / Newly added book object, null
     */
    public Book addBook(int id, String name, String author, int publish) {
        if (searchBook(id) != null) {
            System.out.println("해당 ID(" + id + ") 는 이미 존재합니다.");
            return null;
        } else {
            Book newBook = new Book(id, name, author, publish);
            books.add(newBook);
            Collections.sort(books); // 항상 정렬 상태 유지
            System.out.println(newBook + " 도서가 추가되었습니다.");
            return newBook;
        }
    }

    /**
     * 도서 찾기에 대한 함수. 파라미터 없음
     * Search for a book without "book id".
     */
    public void searchBook() {
        System.out.println("검색된 도서가 없습니다.");
    }

    /**
     * 도서 탐색하기에 대한 함수
     * 검색한 책이 존재하면 해당 책 객체를 반환, 그렇지 않으면 null을 반환.
     * Search for a book from the book list.
     * Return the book object if found, or return null.
     *
     * @param id 찾을 책 ID / Book ID to search
     * @return 책 객체, null / Book object, null
     */
    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("검색 결과:");
                System.out.println(book);
                return book;
            }
        }
        System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        return null;
    }

    /**
     * 이진 탐색을 이용한 책 검색.
     * Search for a book using binary search.
     *
     * @param id 찾을 책 ID / Book ID to search
     * @return 책 객체, null / Book object, null
     */
    public Book search_bs(int id) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = books.get(mid);

            if (midBook.getId() == id) {
                return midBook;
            } else if (midBook.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    /**
     * id에 맞는 도서 삭제.
     * Remove a book from the book list.
     *
     * @param id 삭제 할 책 ID / Book ID to be removed
     */
    public void removeBook(int id) {
        Book removedBook = books.get(id);
        books.remove(id);
        System.out.println(removedBook.toString() + "도서를 삭제하였습니다.");
    }

}
