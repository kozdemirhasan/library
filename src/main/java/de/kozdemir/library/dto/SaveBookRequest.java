package de.kozdemir.library.dto;

import de.kozdemir.library.model.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Data
public final class SaveBookRequest {
//    @NotNull
//    @NotEmpty(message = "title not be empty")
    @NotBlank
    private String title;

    @NotBlank
    private String authorName;

    @NotNull
    private BookStatus bookStatus;

    @NotBlank
    private String publisher;

    @NotNull
    private Integer lastPageNumber;

    private File image;

    @NotNull
    private  Long categoryId;

    @NotNull
    private Integer totalPage;
}
