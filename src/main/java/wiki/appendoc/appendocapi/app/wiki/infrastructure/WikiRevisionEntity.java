package wiki.appendoc.appendocapi.app.wiki.infrastructure;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "wiki_revision",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_WIKI_REVISION_REVID", columnNames = {"wiki_revision_domain_id"})
        }
)
public class WikiRevisionEntity {

    @Id
    @GeneratedValue
    @Column(name = "wiki_revision_id")
    private Long id = null;

    @Column(name = "wiki_revision_domain_id")
    private String wikiRevisionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wiki_document_id")
    private WikiDocumentEntity document;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author_id", nullable = false)
    private String authorId;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Builder
    public WikiRevisionEntity(Long id, String wikiRevisionId, WikiDocumentEntity document, String content, String authorId, LocalDateTime createdDate) {
        this.id = id;
        this.wikiRevisionId = wikiRevisionId;
        this.document = document;
        this.content = content;
        this.authorId = authorId;
        this.createdDate = createdDate;
    }
}
