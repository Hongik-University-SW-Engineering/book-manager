package book;

import java.util.HashMap;
import java.util.Map;

public class BookManager {

    private final Map<Integer, Book> books = new HashMap<>();

    public void addBook(int id, String name, String author, int publish) {
        if (books.get(id) != null) {
            System.out.println("해당 ID(" + id + ") 는 이미 존재합니다.");
        } else {
            Book newBook = new Book(id, name, author, publish);
            books.put(id, newBook);
            System.out.println(newBook.toString() + "도서가 추가되었습니다.");
        }
    }

    public void searchBook() {
        System.out.println("검색된 도서가 없습니다.");
    }

    public void searchBook(int id) {
        Book searchedBook = books.get(id);
        if (searchedBook == null) {
            System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        } else {
            System.out.println("검색 결과:");
            System.out.println(searchedBook.toString());
        }
    }
    public void removeBook(int id) {
        Book removedBook = books.get(id);
        books.remove(id);
        System.out.println(removedBook.toString() + "도서를 삭제하였습니다.");
    }

}
