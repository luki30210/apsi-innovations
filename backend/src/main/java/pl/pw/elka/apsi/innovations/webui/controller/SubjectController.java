package pl.pw.elka.apsi.innovations.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.elka.apsi.innovations.application.SubjectService;
import pl.pw.elka.apsi.innovations.webui.dto.SubjectDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> addSubject(@Valid @RequestBody String subjectName) {
        return ResponseEntity.ok(subjectService.addSubject(subjectName));
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getSubjects(Pageable pageable) {
        return ResponseEntity.ok(subjectService.getSubjects(pageable));
    }
}
