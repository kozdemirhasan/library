package de.kozdemir.library.repository;

import de.kozdemir.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
