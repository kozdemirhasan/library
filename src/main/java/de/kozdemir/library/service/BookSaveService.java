package de.kozdemir.library.service;

import de.kozdemir.library.dto.BookListItemResponse;
import de.kozdemir.library.dto.SaveBookRequest;
import de.kozdemir.library.model.Book;
import de.kozdemir.library.model.Category;
import de.kozdemir.library.repository.BookRepository;
import de.kozdemir.library.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        System.out.println(("YYYY: " + saveBookRequest.getCategoryId()));
        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());
        System.out.println("TTTTT: " + category.getName());

        final Book book = Book.builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .publisher(saveBookRequest.getPublisher())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .authorName(saveBookRequest.getAuthorName())
                .totalPage(saveBookRequest.getTotalPage())
                .build();


        final Book fromDb = bookRepository.save(book);

        return BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(fromDb.getId())
                .bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher())
                .authorName(fromDb.getAuthorName())
                .totalPage(fromDb.getTotalPage())
                .lastPageNumber(fromDb.getLastPageNumber())
                .title(fromDb.getTitle())
                .build();

    }

}
