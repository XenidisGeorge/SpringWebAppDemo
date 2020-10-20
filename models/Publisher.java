package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;
    private String publisherAddress;

    //    Building a many-to-many relation between authors and publishers.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_publisher", joinColumns = @JoinColumn(name = "publisher_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> publishedAuthors = new HashSet<>();

    //    Building a one-to-many relation between books and publishers. Each book has only one publisher.
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Book> publishedBooks = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String publisherName, String publisherAddress) {
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
    }

//    Getters and Setters are below...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Set<Author> getPublishedAuthors() {
        return publishedAuthors;
    }

    public void setPublishedAuthors(Set<Author> publishedAuthors) {
        this.publishedAuthors = publishedAuthors;
    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

//    Overrides are below...


    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publisherAddress='" + publisherAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
