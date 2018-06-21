package pl.pw.elka.apsi.innovations.webui.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by Łukasz on 2018-06-16.
 */
@Getter
@Setter
public class RatingDto {
    private long id;

    private long ideaId;

    @NotNull
    private int value;

    private String opinion;
}
