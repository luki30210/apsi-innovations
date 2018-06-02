package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.application.assembler.SubjectAssembler;
import pl.pw.elka.apsi.innovations.domain.subject.Subject;
import pl.pw.elka.apsi.innovations.domain.subject.SubjectRepository;
import pl.pw.elka.apsi.innovations.shared.exception.SubjectNotFoundException;
import pl.pw.elka.apsi.innovations.webui.dto.SubjectDto;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDto addSubject(String subjectName) {
        return SubjectAssembler.assemble(subjectRepository.save(new Subject(subjectName)));
    }

    public Subject getSubject(Long subjectId) {
        final Optional<Subject> subject = subjectRepository.findById(subjectId);

        if (subject.isPresent()) {
            return subject.get();
        }
        throw new SubjectNotFoundException("Subject with id " + subjectId + " does not exist.");
    }

    public List<SubjectDto> getSubjects(Pageable pageable) {
        return SubjectAssembler.assemble(subjectRepository.findAll(pageable).getContent());
    }
}
