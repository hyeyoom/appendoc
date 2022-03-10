package wiki.appendoc.appendocapi.app.wiki.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문서 생성 서비스 테스트")
class CreateDocumentServiceImplTest {

    private CreateDocumentService sut;
    private WikiDocumentDomainRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TestWikiDocumentDomainRepository();
        sut = new CreateDocumentServiceImpl(
                repository
        );
    }

    @DisplayName("이미 존재하는 문서가 있고, 해당 문서의 제목으로 생성을 시도하는 경우 예외 발생")
    @Test
    void testDuplicatedTitleOfDocument() {

        // given
        final String title = "new document";
        repository.save(
                WikiDocument.createNewDocument(
                        title,
                        "히히",
                        UUID.randomUUID().toString(),
                        LocalDateTime.now()
                )
        );

        // when
        assertThrows(
                CreateDocumentException.class,
                () -> {
                    sut.createNewDocument(
                            new CreateDocumentRequest(
                                    title,
                                    "내용",
                                    UUID.randomUUID().toString(),
                                    LocalDateTime.now()
                            )
                    );
                }
        );
    }
}
