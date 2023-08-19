package de.kozdemir.library.service;

import de.kozdemir.library.dto.BookListItemResponse;
import de.kozdemir.library.dto.SaveBookRequest;
import de.kozdemir.library.model.Book;
import de.kozdemir.library.model.Category;
import de.kozdemir.library.repository.BookRepository;
import de.kozdemir.library.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Service
@RequiredArgsConstructor
public class BookSaveService {
    private final BookRepository bookRepository;

//    public BookSaveService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    private final CategoryService categoryService;

    @Transactional
    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest) {
        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());

        final Book book = Book.builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .totalPage(saveBookRequest.getTotalPage())
                .authorName(saveBookRequest.getAuthorName())
                .build();

        final Book fromDb = bookRepository.save(book);

        return   BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(fromDb.getId())
                .bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher())
                .authorName(fromDb.getAuthorName())
                .totalPage(fromDb.getTotalPage())
                .lastPageNumber(fromDb.getLastPageNumber())
                .build();

    }

}
