package pl.pw.elka.apsi.innovations.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.elka.apsi.innovations.application.IdeaService;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDetailsDto;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/idea")
public class IdeaController {
    private final IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping
    public ResponseEntity<IdeaDto> addIdea(@Valid @RequestBody IdeaDto ideaDto) {
        return ResponseEntity.ok(ideaService.addIdea(ideaDto));
    }

    @GetMapping
    public ResponseEntity<List<IdeaDto>> getIdeas(Pageable pageable) {
        return ResponseEntity.ok(ideaService.getIdeas(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getAllIdeasCount() {
        return ResponseEntity.ok(ideaService.getIdeasCount());
    }

    @GetMapping("/{ideaId}")
    public ResponseEntity<IdeaDetailsDto> getIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.getIdeaDetailsDto(ideaId));
    }
}
