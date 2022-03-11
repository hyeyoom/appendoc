package wiki.appendoc.appendocapi.app.wiki.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WikiDocumentJpaRepository extends JpaRepository<WikiDocumentEntity, Long> {

    @Query(
            "SELECT wde " +
              "FROM WikiDocumentEntity wde " +
        "JOIN FETCH wde.revisions " +
             "WHERE wde.title = :title "
    )
    Optional<WikiDocumentEntity> findByTitle(String title);
}
