package pl.pw.elka.apsi.innovations.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(String reason) {
        super(reason);
    }
}
