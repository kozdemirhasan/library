package de.kozdemir.library.dto;

import de.kozdemir.library.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 21.09.2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private Role role;
    private String email;

}
