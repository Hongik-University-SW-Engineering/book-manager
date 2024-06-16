package book;

public class Book implements Comparable<Book>{
    private int id;
    private String name;
    private String author;
    private int publish;

    /**
     * 생성자
     * @param id
     * @param name
     * @param author
     * @param publish
     */
    public Book(int id, String name, String author, int publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }


    /**
     * toString overriding 하여 다형성 구현.
     * @return
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
     * getter 함수.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 비교하기
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }
}
