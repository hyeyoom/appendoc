package wiki.appendoc.appendocapi.app.wiki.application;

import org.springframework.stereotype.Service;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentResponse;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

@Service
public class CreateDocumentServiceImpl implements CreateDocumentService {

    private final WikiDocumentDomainRepository repository;

    public CreateDocumentServiceImpl(WikiDocumentDomainRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateDocumentResponse createNewDocument(CreateDocumentRequest request) {
        final WikiDocument maybeDocument = repository.getByTitle(request.getTitle());
        if (maybeDocument != null) {
            throw new CreateDocumentException(
                    "해당 이름을 가진 문서가 이미 존재합니다: " + request.getTitle()
            );
        }

        final WikiDocument newDocument = WikiDocument.createNewDocument(
                request.getTitle(),
                request.getContent(),
                request.getAuthorId(),
                request.getCreatedDate()
        );

        final WikiDocument savedDocument = repository.save(newDocument);
        return new CreateDocumentResponse(
                savedDocument.getWikiDocumentId().getValue()
        );
    }
}
