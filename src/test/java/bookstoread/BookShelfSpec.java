package bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("A BookShelf")
public class BookShelfSpec {

    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;
    private Book theAlchemist;
    private Book cleanCode;

    @BeforeEach
    void init() throws Exception {
        shelf = new BookShelf();
        effectiveJava = new Book("Effective Java", "Jousha Bloch", LocalDate.of(2008, Month.MAY, 8));
        codeComplete = new Book("Code Complete", "Steve McConnel", LocalDate.of(2004, Month.JUNE, 9));
        theAlchemist = new Book("The Alchemist", "Paulo Coelho", LocalDate.of(1988, Month.JULY, 10));
        cleanCode = new Book("Clean Code", "Clean Coder", LocalDate.of(2008, Month.JULY, 10));
    }


    @Test
    @DisplayName("is empty when no book is added to it")
    public void shelfEmptyWhenNoBookAdded() throws Exception {

        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "Book Shelf should be empty");
    }

    // if we add two books to the shelf will have two books

    @Test
    @DisplayName("book shelf contains two books when added two books")
    void bookShelfContainsTwoBooksWhenTwoBooksAdded() {

        shelf.add(effectiveJava, codeComplete);
        List<Book> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have 2 books");
    }


    // if no book passed in the add method

    @Test
    @DisplayName("empty bookshelf remains empty when add is called without books")
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {

        shelf.add();
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty");
    }

    // client can't add to the books' collection returned by the shelf

    @Test
    @DisplayName("bookshelf returns immutable books collection to the client")
    public void booksReturnedFromBookShelfIsImmutableForClient() {

        shelf.add(effectiveJava, codeComplete);
        List<Book> books = shelf.books();
        try {
            books.add(theAlchemist);
            fail(() -> "Should not be able to add to the books");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should Throw UnsupportedOperationException");
        }
    }

    // Feature Second: User should be able to arrange the bookshelf based on certain criteria
    // Write a failing test case first.
    // Refactor the code
    // Check if pass
    // Refactor more if needed
    @Test
    @DisplayName("bookshelf is arranged lexicographically by book title")
    void bookShelfArrangedByBookTitle() {
        shelf.add(effectiveJava, codeComplete, theAlchemist);
        List<Book> books = shelf.arrange(); // this feature needed. Write test first. fail. repeat
        assertEquals(Arrays.asList(codeComplete, effectiveJava, theAlchemist), books, () -> "Books in bookshelf should be lexicographically arranged by book title");
    }

    @Test
    @DisplayName("Books shelf remain in insertion order even when arranged")
    void booksInShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add(effectiveJava, codeComplete, theAlchemist);
        shelf.arrange();
        List<Book> books = shelf.books();
        assertEquals(Arrays.asList(effectiveJava, codeComplete, theAlchemist), books, () -> "Books in bookshelf are in insertion Order");
    }


    // books arranged by user criterion

    @Test
    @DisplayName("bookshelf are grouped according to user provided criteria")
    void bookShelfArrangedByProvidedUserCriterion() {
        shelf.add(effectiveJava, codeComplete, theAlchemist);
//        List<Book> books = shelf.arrange(Comparator.<Book>naturalOrder().reversed());
//        assertEquals(
//                Arrays.asList(theAlchemist,effectiveJava,codeComplete),books,()->"Books in a bookshelf are arranged in descending order of the title"
//        );

        Comparator<Book> reversed = Comparator.<Book>naturalOrder().reversed();
        List<Book> books = shelf.arrange(reversed);

        assertThat(books).isSortedAccordingTo(reversed);

    }

    @Test
    @DisplayName("BookShelf is arranged by date")
    void bookShelfArrangedByDate() {
        shelf.add(effectiveJava, codeComplete, theAlchemist);
        List<Book> books = shelf.arrangeByDate();
        assertEquals(
                Arrays.asList(theAlchemist, codeComplete, effectiveJava), books, () -> "books should be arranged according to date by ascending order`"
        );
    }

    //as a user I should be able to group books in bookshelf based on criteria

    @Test
    @DisplayName("books inside bookshelf are grouped by publication year")
    void groupBooksInsideBookShelfByPublicationYear() {
        shelf.add(effectiveJava, codeComplete, theAlchemist, cleanCode);

        Map<Year, List<Book>> booksByPublicationYear = shelf.groupByPublicationYear();

        assertThat(booksByPublicationYear)
                .containsKey(Year.of(2008))
                .containsValue(Arrays.asList(effectiveJava, cleanCode));

        assertThat(booksByPublicationYear)
                .containsKey(Year.of(2004))
                .containsValue(Arrays.asList(codeComplete));

        assertThat(booksByPublicationYear)
                .containsKey(Year.of(1988))
                .containsValue(Arrays.asList(theAlchemist));

    }

    // client can specify their grouping criteria

    @Test
    @DisplayName("book inside bookshelf are grouped according to user criteria")
    void groupBooksByUserProvidedCriteria() {
        shelf.add(effectiveJava, codeComplete, theAlchemist, cleanCode);
        Map<String, List<Book>> booksByAuthor = shelf.groupBy(Book::getAuthor);

        assertThat(booksByAuthor)
                .containsKey("Joshua Bloch")
                .containsValues(singletonList(effectiveJava));

        assertThat(booksByAuthor)
                .containsKey("Steve McConnel")
                .containsValues(singletonList(codeComplete));


        assertThat(booksByAuthor)
                .containsKey("Paulo Coelho")
                .containsValues(singletonList(theAlchemist));


        assertThat(booksByAuthor)
                .containsKey("Clean Code")
                .containsValues(singletonList(cleanCode));
    }


}
