package com.mindtree.shoppingCart.book.entity;

import com.mindtree.shoppingCart.product.entity.Product;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author M1053969
 * Book entity class
 */
@Entity
@Table(name="Book")
@DiscriminatorValue(value ="Book")
public class Book extends Product implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publications;

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publications
     */
    public String getPublications() {
        return publications;
    }

    /**
     * @param publications the publications to set
     */
    public void setPublications(String publications) {
        this.publications = publications;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((publications == null) ? 0 : publications.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (publications == null) {
            if (other.publications != null)
                return false;
        } else if (!publications.equals(other.publications))
            return false;
        return true;
    }
}
