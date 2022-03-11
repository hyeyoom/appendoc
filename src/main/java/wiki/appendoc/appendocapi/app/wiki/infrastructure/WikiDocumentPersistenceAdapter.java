package wiki.appendoc.appendocapi.app.wiki.infrastructure;

import org.springframework.stereotype.Repository;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

import java.util.Optional;

@Repository
public class WikiDocumentPersistenceAdapter implements WikiDocumentDomainRepository {

    private final WikiDocumentJpaRepository repository;

    public WikiDocumentPersistenceAdapter(WikiDocumentJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public WikiDocument getByTitle(String title) {
        final Optional<WikiDocumentEntity> optionalEntity = repository.findByTitle(title);
        final WikiDocumentEntity maybeEntity = optionalEntity.orElseGet(() -> null);
        if (maybeEntity == null) {
            return null;
        }
        return WikiDocumentAssembler.fromEntity(maybeEntity);
    }

    @Override
    public WikiDocument save(WikiDocument wikiDocument) {
        final WikiDocumentEntity entity = WikiDocumentAssembler.fromDomain(wikiDocument);
        repository.save(entity);
        return wikiDocument;
    }
}
