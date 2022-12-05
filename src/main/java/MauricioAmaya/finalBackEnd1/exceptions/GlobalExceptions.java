package MauricioAmaya.finalBackEnd1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({ResourcesNotFoundException.class})
    public ResponseEntity<String> procesarResourcesNotFoundException(ResourcesNotFoundException rnfe){
        // esto devuelve un cartel generico para las excepciones
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rnfe.getMessage());
    }


}
