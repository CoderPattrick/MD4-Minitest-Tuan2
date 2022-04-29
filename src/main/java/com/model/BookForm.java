package com.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Component
public class BookForm {
    private Long id;
    private String name;
    private String author;
    private String description;
    private MultipartFile image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public BookForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BookForm(String name, String author, String description, MultipartFile image, Category category) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public BookForm(Long id, String name, String author, String description, MultipartFile image, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
