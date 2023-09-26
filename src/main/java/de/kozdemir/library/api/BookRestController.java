package de.kozdemir.library.api;


import de.kozdemir.library.dto.BookListItemResponse;
import de.kozdemir.library.dto.BookResponse;
import de.kozdemir.library.dto.CategoryType;
import de.kozdemir.library.dto.SaveBookRequest;
import de.kozdemir.library.service.BookListService;
import de.kozdemir.library.service.BookSaveService;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 19.08.2023
 */
@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
//@Api(value = "book Api documentation")
public class BookRestController {


    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping("/save")
//    @ApiOperation(value = "New Book adding method")
    public ResponseEntity<BookListItemResponse> saveBook(@RequestBody SaveBookRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam(name = "size") int size, @RequestParam(name = "page") int page) {
        return ResponseEntity.ok(bookListService.listBooks(size, page));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType) {
        return ResponseEntity.ok(this.bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listBy(@PathVariable String title) {
        return ResponseEntity.ok(this.bookListService.searchByTitle(title));
    }


}
