package de.kozdemir.library.exception;

import de.kozdemir.library.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;


/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 19.08.2023
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericException extends Exception{
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

}
