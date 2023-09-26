package de.kozdemir.library.service;

import de.kozdemir.library.dto.BookResponse;
import de.kozdemir.library.dto.CategoryType;
import de.kozdemir.library.model.Book;
import de.kozdemir.library.model.BookStatus;
import de.kozdemir.library.model.Category;
import de.kozdemir.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Service
@RequiredArgsConstructor
public class BookListService {
    private final CategoryService categoryService;
    private final BookRepository bookRepository;

    //    CONVERT REQUEST PARAM
    public List<BookResponse> listBooks(int size, int page) {
        return bookRepository.findAll(PageRequest.of(size, page))
                .getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    private static BookResponse convertResponse(Book model) {
        return BookResponse.builder()
                .authorName(model.getAuthorName())
                .title(model.getTitle())
                .imageUrl(model.getImage().getImageUrl())
                .build();
    }

    public List<BookResponse> searchByCategory(CategoryType categoryType) {
        final Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build())
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build())
                .collect(Collectors.toList());
    }

}
