package de.kozdemir.library.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Entity
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    @Column(unique = true) // username muss unique sein
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

}
