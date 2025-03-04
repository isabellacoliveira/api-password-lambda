package passwordApp.infra;


import passwordApp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HasUpperException.class)
    protected ResponseEntity<RestErrorMessage> hasUpperHandler(HasUpperException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HasSpecialCharacterException.class)
    protected ResponseEntity<RestErrorMessage> hasSpecialCharactersHandler(HasSpecialCharacterException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HasLowerException.class)
    protected ResponseEntity<RestErrorMessage> hasLowerHandler(HasLowerException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MinimunCharactersException.class)
    protected ResponseEntity<RestErrorMessage> minimunOfCharactersHandler(MinimunCharactersException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotEmptyException.class)
    protected ResponseEntity<RestErrorMessage> notEmptyHandler(NotEmptyException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RepeatedCharacterException.class)
    protected ResponseEntity<RestErrorMessage> repeatedCharacterHandler(RepeatedCharacterException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
