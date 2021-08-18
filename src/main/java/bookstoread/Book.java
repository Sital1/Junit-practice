package bookstoread;

import java.time.LocalDate;

public class Book implements Comparable<Book>{
    private final String title;
    private final String author;
    private final LocalDate publishedOn;

    public Book(String title, String author, LocalDate publishedOn) {
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedOn=" + publishedOn +
                '}';
    }

    @Override
    public int compareTo(Book that) {
        return this.title.compareTo(that.title);
    }

    public int compareTo(LocalDate date)
    {
        if(this.publishedOn.isEqual(date))
        {
            return 0;
        }
        else if(this.publishedOn.isAfter(date))
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}
