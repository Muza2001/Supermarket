package uzdigitl.one.springbootappsupermarket.exeption;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExeption extends ExceptionInInitializerError {

    /**
     * Constructs a BadAttributeValueExpException using the specified Object to
     * create the toString() value.
     *
     * @param val the inappropriate value.
     */
    public BadRequestExeption(Object val) {
        super((Throwable) val);
    }

    private String message;
    public BadRequestExeption(String message) {
        this.message = message;
    }
}
