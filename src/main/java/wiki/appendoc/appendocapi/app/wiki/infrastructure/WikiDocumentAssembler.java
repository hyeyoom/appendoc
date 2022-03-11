package wiki.appendoc.appendocapi.app.wiki.infrastructure;

import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentId;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiRevision;

import java.util.List;
import java.util.stream.Collectors;

final class WikiDocumentAssembler {

    public static WikiDocument fromEntity(WikiDocumentEntity entity) {
        final WikiDocumentId wikiDocumentId = WikiDocumentId.of(entity.getWikiDocumentId());
        final List<WikiRevision> revisions = entity
                .getRevisions()
                .stream()
                .map(wikiRevisionEntity -> {
                    return WikiRevision.of(
                            wikiDocumentId,
                            wikiRevisionEntity.getContent(),
                            wikiRevisionEntity.getCreatedDate(),
                            wikiRevisionEntity.getAuthorId()
                    );
                })
                .collect(Collectors.toList());
        return WikiDocument.from(
                wikiDocumentId,
                entity.getTitle(),
                entity.getCreatedDate(),
                revisions
        );
    }

    public static WikiDocumentEntity fromDomain(WikiDocument wikiDocument) {
        final WikiDocumentEntity documentEntity = WikiDocumentEntity.builder()
                .wikiDocumentId(wikiDocument.getWikiDocumentId().getValue())
                .title(wikiDocument.getTitle())
                .createdDate(wikiDocument.getCreatedDate())
                .build();

        final WikiRevision revision = wikiDocument.getLatestRevision();
        final WikiRevisionEntity revisionEntity = WikiRevisionEntity.builder()
                .wikiRevisionId(revision.getWikiRevisionId().getValue())
                .authorId(revision.getAuthorId())
                .content(revision.getContent())
                .createdDate(revision.getCreatedDate())
                .document(documentEntity)
                .build();

        documentEntity.addRevision(revisionEntity);
        return documentEntity;
    }
}
