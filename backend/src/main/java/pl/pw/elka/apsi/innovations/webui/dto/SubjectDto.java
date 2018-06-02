package pl.pw.elka.apsi.innovations.webui.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubjectDto {
    private long id;

    @NotNull
    private String name;
}
