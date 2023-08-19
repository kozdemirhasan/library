package de.kozdemir.library.dto;

import de.kozdemir.library.model.BookStatus;
import de.kozdemir.library.model.Image;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Integer totalPage;
    private Long categoryId;
    private String imageUrl;
}
