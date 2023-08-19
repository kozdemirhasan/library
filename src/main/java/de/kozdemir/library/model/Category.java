package de.kozdemir.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Entity
@Table(name="category")
@Getter
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore // Kategori eklerken bir kitap eklemeyi istemesin
    private List<Book> books;
}
