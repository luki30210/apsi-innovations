package pl.pw.elka.apsi.innovations.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.elka.apsi.innovations.application.IdeaService;
import pl.pw.elka.apsi.innovations.webui.dto.IdeaDto;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public ResponseEntity<List<IdeaDto>> getAllIdeas() {
        // TODO: Get all ideas
        List<IdeaDto> ideaDtos = new ArrayList<>();
        return ResponseEntity.ok(ideaDtos);
    }
}
