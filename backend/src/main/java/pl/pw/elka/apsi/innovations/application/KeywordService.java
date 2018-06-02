package pl.pw.elka.apsi.innovations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.elka.apsi.innovations.domain.keyword.Keyword;
import pl.pw.elka.apsi.innovations.domain.keyword.KeywordRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class KeywordService {
    private KeywordRepository keywordRepository;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public Set<Keyword> getOrCreateAndGetIfNotExist(Set<String> keywords) {
        final Set<Keyword> keywordsDb = keywords.stream().map(keyword -> {
            final Optional<Keyword> foundKeyword = keywordRepository.findById(keyword);
            if (foundKeyword.isPresent()) {
                return foundKeyword.get();
            }
            return keywordRepository.save(new Keyword(keyword));
        }).collect(Collectors.toSet());

        return keywordsDb;
    }
}
