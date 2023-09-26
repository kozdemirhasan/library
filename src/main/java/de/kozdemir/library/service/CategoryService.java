package de.kozdemir.library.service;

import de.kozdemir.library.model.Category;
import de.kozdemir.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category findByName(String value) {
        return categoryRepository.findByName(value).orElseThrow(RuntimeException::new );
    }
}
