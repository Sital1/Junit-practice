package bookstoread;


import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookShelf {


    private final List<Book> books = new ArrayList<bookstoread.Book>();

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    public void add(Book... booksToAdd) {

        Arrays.stream(booksToAdd).forEach(books::add);

    }

    // First implementation of Second implementation. This will arrange the underlying collection as well.
    // Refactor
    // Write ANOTHER TEST CASE for that.

//        public List<String> arrange()
//        {
//            books.sort(Comparator.naturalOrder());
//            return books;
//        }

    // to not change the underlying collection return new Sorted collection.

    public List<Book> arrange()
    {

        return arrange(Comparator.naturalOrder());
    }

    public List<Book> arrange(Comparator<Book> criteria)
    {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }

    public List<Book> arrangeByDate()
    {
        List<Book> newBook = books.stream().collect(Collectors.toList());
        Collections.sort(newBook,new DateSorter());
        return newBook;
    }

    // as a user I should be able to group books in bookshelf based on criteria

    public <K> Map<Year, List<Book>> groupByPublicationYear() {
        return groupBy(book -> Year.of(book.getPublishedOn().getYear()));
    }

    public <K> Map<K,List<Book>> groupBy(Function<Book ,K> fx)
    {
        return books.stream()
                .collect(Collectors.groupingBy(fx));
    }


}
