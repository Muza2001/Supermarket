package uzdigitl.one.springbootappsupermarket.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundExeption extends Exception{

    public ObjectNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ObjectNotFoundExeption(String message) {
        super(message);
    }
}
