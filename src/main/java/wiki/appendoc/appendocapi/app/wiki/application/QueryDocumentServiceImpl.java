package wiki.appendoc.appendocapi.app.wiki.application;

import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQuery;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQueryResult;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

public class QueryDocumentServiceImpl implements QueryDocumentService {

    private final WikiDocumentDomainRepository repository;

    public QueryDocumentServiceImpl(WikiDocumentDomainRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReadDocumentQueryResult readDocument(ReadDocumentQuery query) {
        final WikiDocument maybeDocument = repository.getByTitle(query.getTitle());

        if (maybeDocument == null) {
            throw new QueryDocumentException("문서를 찾을 수 없습니다.");
        }

        return new ReadDocumentQueryResult(
                maybeDocument.getTitle(),
                maybeDocument.getLatestRevision().getContent(),
                maybeDocument.getLatestRevision().getCreatedDate()
        );
    }
}
