package pl.pw.elka.apsi.innovations.application.assembler;

import org.springframework.stereotype.Component;
import pl.pw.elka.apsi.innovations.domain.subject.Subject;
import pl.pw.elka.apsi.innovations.webui.dto.SubjectDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectAssembler {
    private SubjectAssembler() {
    }

    public static SubjectDto assemble(Subject subject) {
        SubjectDto dto = new SubjectDto();

        dto.setId(subject.getId());
        dto.setName(subject.getName());

        return dto;
    }

    public static List<SubjectDto> assemble(List<Subject> subjects) {
        return subjects.stream().map(SubjectAssembler::assemble).collect(Collectors.toList());
    }
}
