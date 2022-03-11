package wiki.appendoc.appendocapi.app.wiki.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQuery;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQueryResult;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("문서 조회 서비스 테스트")
class QueryDocumentServiceImplTest {

    private WikiDocumentDomainRepository mockRepository;
    private QueryDocumentService sut;

    @BeforeEach
    void setUp() {
        mockRepository = mock(WikiDocumentDomainRepository.class);
        sut = new QueryDocumentServiceImpl(mockRepository);
    }

    @DisplayName("조회하려는 문서가 존재하지 않는 경우, QueryDocumentException이 발생함")
    @Test
    void testThrowException() {

        // given
        final String title = "Appendoc";

        // when & then
        assertThrows(
                QueryDocumentException.class,
                () -> {
                    sut.readDocument(new ReadDocumentQuery(title));
                }
        );
    }

    @DisplayName("저장한 문서가 잘 조회된다")
    @Test
    void testHappy() {

        // given
        final String title = "Appendoc";
        final String content = "Minimal Wiki";
        final String authorId = UUID.randomUUID().toString();
        final LocalDateTime createdDate = LocalDateTime.now();
        final WikiDocument existingDocument = WikiDocument.createNewDocument(
                title,
                content,
                authorId,
                createdDate
        );

        // stub
        when(mockRepository.getByTitle(anyString())).thenReturn(existingDocument);

        // when
        final ReadDocumentQueryResult result = sut.readDocument(new ReadDocumentQuery(title));

        // then
        assertEquals(title, result.getTitle());
        assertEquals(content, result.getContent());
        assertEquals(createdDate, result.getCreatedDate());
    }
}