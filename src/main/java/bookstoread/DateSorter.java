package bookstoread;

import java.util.Comparator;

public class DateSorter implements Comparator<Book> {


    @Override
    public int compare(Book book1, Book book2) {
        return book1.getPublishedOn().compareTo(book2.getPublishedOn());
    }
}
