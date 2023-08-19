package de.kozdemir.library.repository;

import de.kozdemir.library.model.Book;
import de.kozdemir.library.model.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> , JpaSpecificationExecutor<Book> {
    List<Book> findByStatus(BookStatus bookStatus);
    List<Book> findByTitle(String title);

}
