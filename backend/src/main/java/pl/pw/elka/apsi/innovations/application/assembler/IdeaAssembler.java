package pl.pw.elka.apsi.innovations.application.assembler;

import org.springframework.stereotype.Component;
import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IdeaAssembler {
    private IdeaAssembler() {}

    public static IdeaDto assemble(Idea idea) {
        IdeaDto dto = new IdeaDto();

        dto.setId(idea.getId());
        dto.setName(idea.getName());
        dto.setDescription(idea.getDescription());
        dto.setSubject(idea.getSubject() != null ? idea.getSubject().getName() : "");
        dto.setKeywords(idea.getKeywords() != null ? idea.getKeywords().stream().map(k -> k.getWord()).collect(Collectors.toSet()) : null);
        dto.setBenefits(idea.getBenefits());
        dto.setCosts(idea.getCosts());
        dto.setStatus(idea.getStatus());
        dto.setAdditionDate(idea.getAdditionDate());

        return dto;
    }

    public static List<IdeaDto> assemble(List<Idea> ideas) {
        return ideas.stream().map(IdeaAssembler::assemble).collect(Collectors.toList());
    }
}
