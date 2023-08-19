package de.kozdemir.library.dto;

import de.kozdemir.library.model.BookStatus;
import de.kozdemir.library.model.Image;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Data
@SuperBuilder
public class BookListItemResponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private String categoryName;
    private Integer totalPage;
}
