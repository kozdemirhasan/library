package de.kozdemir.library.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */

@Entity
@Table(name="images")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity {
    private String imageUrl;

}
