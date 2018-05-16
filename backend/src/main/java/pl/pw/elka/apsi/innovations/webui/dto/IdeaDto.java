package pl.pw.elka.apsi.innovations.webui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class IdeaDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String subject;

    private Set<String> keywords;

    @NotNull
    private String benefits;

    @NotNull
    private String costs;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String status; // TODO Seperate table?

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date additionDate;
}
