package wiki.appendoc.appendocapi.app.wiki.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("위키 도메인 테스트")
class WikiDocumentTest {

    @DisplayName("of 생성자 테스트")
    @Test
    void test() {

        // given
        final String title = "appendoc";
        final String content = "wiki";
        final String authorId = UUID.randomUUID().toString();
        final LocalDateTime createdDate = LocalDateTime.of(2022, 3, 10, 0, 0);

        // when
        final WikiDocument document = WikiDocument.createNewDocument(title, content, authorId, createdDate);

        // then
        final WikiRevision latestRevision = document.getLatestRevision();
        assertNotNull(latestRevision);
        assertEquals(title, document.getTitle());
        assertEquals(content, latestRevision.getContent());
        assertEquals(authorId, latestRevision.getAuthorId());
        assertEquals(createdDate, document.getCreatedDate());
    }
}
