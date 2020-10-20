package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String cardId;
    private String address;
    private Long vatNumber;

    @ManyToMany(mappedBy = "setOfAuthors", cascade = CascadeType.ALL)
    private Set<Book> setOfBooks = new HashSet<>();

    @ManyToMany(mappedBy = "publishedAuthors", cascade = CascadeType.ALL)
    private Set<Publisher> setOfPublishers = new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName, String cardId, String address, Long vatNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardId = cardId;
        this.address = address;
        this.vatNumber = vatNumber;
    }

    //    Getters and Setters are below...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Long vatNumber) {
        this.vatNumber = vatNumber;
    }

    public Set<Book> getSetOfBooks() {
        return setOfBooks;
    }

    public void setSetOfBooks(Set<Book> setOfBooks) {
        this.setOfBooks = setOfBooks;
    }

    public Set<Publisher> getSetOfPublishers() {
        return setOfPublishers;
    }

    public void setSetOfPublishers(Set<Publisher> setOfPublishers) {
        this.setOfPublishers = setOfPublishers;
    }

    //    Overrides are below...


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                ", vatNumber=" + vatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
