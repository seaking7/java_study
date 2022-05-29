package tk.designPattern.prototype;


import java.util.ArrayList;

class Book{
    private String author;
    private String title;

    public Book(String author, String title){
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

class BookShelf implements Cloneable{
    private ArrayList<Book> shelf;

    public BookShelf(){
        shelf = new ArrayList<Book>();
    }

    public void addBook(Book book){
        shelf.add(book);
    }

    public ArrayList<Book> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "shelf=" + shelf.toString() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BookShelf another = new BookShelf();

        for (Book book : shelf) {
            another.addBook(new Book(book.getAuthor(), book.getTitle()));
        }
        return another;
    }
}

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new Book("taekyung", "Harry Porter"));
        bookShelf.addBook(new Book("seaking", "Ring of King"));
        bookShelf.addBook(new Book("make", "Spider Man"));
        System.out.println("bookShelf = " + bookShelf);

        BookShelf another = (BookShelf) bookShelf.clone();
        System.out.println("another = " + another);

        bookShelf.getShelf().get(0).setAuthor("tom");
        bookShelf.getShelf().get(0).setTitle("Dragon");
        System.out.println("bookShelf = " + bookShelf);
        System.out.println("another = " + another);
    }
}
