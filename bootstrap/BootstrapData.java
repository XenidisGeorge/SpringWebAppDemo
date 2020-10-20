package com.example.demo.bootstrap;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BootstrapData implements CommandLineRunner {
    Scanner input;

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final PublisherRepository publisherRepo;

    public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    //    Overrides are below...


    @Override
    public void run(String... args) throws Exception {
        input = new Scanner(System.in);

        System.out.println("Started in bootstrap...");

        System.out.println("Please enter the following attributes for the author with the shown priority:\n" +
                "1) first name,\n" +
                "2) last name,\n" +
                "3) card ID,\n" +
                "4) full address,\n" +
                "5) VAT number.\n");
        String firstName = input.nextLine();
        String lastName = input.nextLine();
        String cardId = input.nextLine();
        String address = input.nextLine();
        Long vatNumber = input.nextLong();

        Author author = new Author(firstName, lastName, cardId, address, vatNumber);
        System.out.println("Inputs accepted");

        System.out.println("Please enter the following attributes for the book record with the shown priority:\n" +
                "1) title,\n" +
                "2) isbn.\n");
        String title = input.nextLine();
        title = input.nextLine();// Revaluing variable "title" because of a bug in the Scanner.
        String isbn = input.nextLine();

        Book book = new Book(title, isbn);
        System.out.println("Inputs accepted");

        System.out.println("Please type below the publisher's attributes with the show priority:\n" +
                "1) publisher's name,\n" +
                "2) publisher's full address.\n");
        String publisherName = input.nextLine();
        String publisherAddress = input.nextLine();

        Publisher publisher = new Publisher(publisherName, publisherAddress);
        System.out.println("Inputs accepted");

        author.getSetOfBooks().add(book);
        author.getSetOfPublishers().add(publisher);
        book.getSetOfAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getPublishedAuthors().add(author);
        publisher.getPublishedBooks().add(book);
        System.out.println("Inputs recorded");

        authorRepo.save(author);
        bookRepo.save(book);
        publisherRepo.save(publisher);

        System.out.println("Registration completed successfully!");

    }
}
