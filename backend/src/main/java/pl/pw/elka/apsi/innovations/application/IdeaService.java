package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.application.assembler.IdeaAssembler;
import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.idea.IdeaRepository;
import pl.pw.elka.apsi.innovations.domain.keyword.Keyword;
import pl.pw.elka.apsi.innovations.domain.subject.Subject;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDto;

import java.util.stream.Collectors;

@Service
public class IdeaService {
    IdeaRepository ideaRepository;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public IdeaDto addIdea(IdeaDto ideaDto) {
        Idea newIdea = new Idea();
        newIdea.setName(ideaDto.getName());
        newIdea.setDescription(ideaDto.getDescription());

        // TODO: Getting subject and keywords from database
        //newIdea.setSubject(new Subject(ideaDto.getSubject()));
        //newIdea.setKeywords(ideaDto.getKeywords().stream().map(k -> new Keyword(k)).collect(Collectors.toSet()));

        newIdea.setBenefits(ideaDto.getBenefits());
        newIdea.setCosts(ideaDto.getCosts());

        newIdea = ideaRepository.save(newIdea);

        return IdeaAssembler.assemble(newIdea);
    }
}
