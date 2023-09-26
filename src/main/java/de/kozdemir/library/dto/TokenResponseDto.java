package de.kozdemir.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 22.09.2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String accessToken;
    private String userDto;

}
