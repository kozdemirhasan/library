package de.kozdemir.library.repository;

import de.kozdemir.library.model.Book;
import de.kozdemir.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Book> {
    Optional<Category> findByName(String name);

}
