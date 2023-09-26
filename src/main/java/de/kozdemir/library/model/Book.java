package de.kozdemir.library.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Entity
@Table(name="book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseEntity {

    private String title;

    private String authorName;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    private String publisher;

    private Integer lastPageNumber;

    private Integer totalPage;

    @OneToOne
    private Image image;

    @ManyToOne //Bir kategori birden fazla kitap icerir
    @JoinColumn(name="category_id")
    private Category category;

    private Long userId;

}
