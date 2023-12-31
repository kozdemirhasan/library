package de.kozdemir.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
