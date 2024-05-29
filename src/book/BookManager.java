package book;

import java.util.*;

public class BookManager {

    private final List<Book> books = new ArrayList<>();

    public Book addBook(int id, String name, String author, int publish) {
        if (search_bs(id) != null) {
            System.out.println("해당 ID(" + id + ") 는 이미 존재합니다.");
            return null;
        } else {
            Book newBook = new Book(id, name, author, publish);
            books.add(newBook);
            Collections.sort(books); // 항상 정렬 상태 유지
            System.out.println(newBook.toString() + " 도서가 추가되었습니다.");
            return newBook;
        }
    }

    public void searchBook() {
        System.out.println("검색된 도서가 없습니다.");
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("검색 결과:");
                System.out.println(book.toString());
                return book;
            }
        }
        System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        return null;
    }

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

    public void removeBook(int id) {
        Book removedBook = books.get(id);
        books.remove(id);
        System.out.println(removedBook.toString() + "도서를 삭제하였습니다.");
    }

}
