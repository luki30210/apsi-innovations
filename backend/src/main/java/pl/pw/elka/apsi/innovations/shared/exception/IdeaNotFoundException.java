package pl.pw.elka.apsi.innovations.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdeaNotFoundException extends RuntimeException {
    public IdeaNotFoundException(String reason) {
        super(reason);
    }
}
