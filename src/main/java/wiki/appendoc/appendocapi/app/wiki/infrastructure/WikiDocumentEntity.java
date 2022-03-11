package wiki.appendoc.appendocapi.app.wiki.infrastructure;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "wiki_document",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_WIKI_DOCUMENT_DOCID", columnNames = {"wiki_document_domain_id"}),
                @UniqueConstraint(name = "UQ_WIKI_DOCUMENT_TITLE", columnNames = {"title"}),
        }
)
public class WikiDocumentEntity {

    @Id
    @GeneratedValue
    @Column(name = "wiki_document_id")
    private Long id = null;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<WikiRevisionEntity> revisions = new ArrayList<>();

    @Column(name = "wiki_document_domain_id")
    private String wikiDocumentId;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Builder
    public WikiDocumentEntity(Long id, String wikiDocumentId, String title, LocalDateTime createdDate) {
        this.id = id;
        this.wikiDocumentId = wikiDocumentId;
        this.title = title;
        this.createdDate = createdDate;
    }

    protected void addRevision(WikiRevisionEntity revisionEntity) {
        revisions.add(revisionEntity);
    }
}
