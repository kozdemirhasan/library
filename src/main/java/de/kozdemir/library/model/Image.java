package de.kozdemir.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */

@Entity
@Table(name="images")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Image extends BaseEntity {
    private String imageUrl;

}
