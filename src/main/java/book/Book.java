package book;

/**
 * 책 정보를 담는 클래스
 * A class that contains book information.
 */
public class Book implements Comparable<Book>{
    private int id;
    private String name;
    private String author;
    private int publish;

    /**
     * 생성자
     * Constructor
     * @param id 책 ID / Book ID
     * @param name 책 이름 / Book name
     * @param author 저자 / Author
     * @param publish 출판년도 / Publish year
     */
    public Book(int id, String name, String author, int publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }


    /**
     * Override toString()
     * 책의 정보를 출력.
     * Print the book information.
     * @return 책 정보 / Book information
     */
    @Override
    public String toString() {
        return "Book{" +
                "id:" + id +
                ", 제목:'" + name + '\'' +
                ", 저자:'" + author + '\'' +
                ", 출판년도:" + publish +
                '}';
    }


    /**
     * Getter.
     * @return 책 ID / Book ID
     */
    public int getId() {
        return id;
    }

    /**
     * 두 책을 비교.
     * Comparing two books.
     * @param other the object to be compared.
     * @return the value 0 if this book is equal to the argument book;
     */
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }
}
