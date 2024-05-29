package book;

public class Book implements Comparable<Book>{
    private int id;
    private String name;
    private String author;
    private int publish;

    public Book(int id, String name, String author, int publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id:" + id +
                ", 제목:'" + name + '\'' +
                ", 저자:'" + author + '\'' +
                ", 출판년도:" + publish +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }
}
