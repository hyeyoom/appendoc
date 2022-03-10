package wiki.appendoc.appendocapi.app.wiki.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("문서 생성 서비스 테스트 by Mock")
class CreateDocumentServiceImplTestWithMock {

    private WikiDocumentDomainRepository mockRepository;
    private CreateDocumentService sut;

    @BeforeEach
    void setUp() {
        mockRepository = mock(WikiDocumentDomainRepository.class);
        sut = new CreateDocumentServiceImpl(mockRepository);
    }

    @DisplayName("이미 존재하는 문서가 있고, 해당 문서의 제목으로 생성을 시도하는 경우 예외 발생")
    @Test
    void testDuplicatedTitleOfDocument() {

        // given
        final WikiDocument mockExistingDocument = WikiDocument.createNewDocument(
                "제목",
                "히히",
                UUID.randomUUID().toString(),
                LocalDateTime.now()
        );
        // stub
        when(mockRepository.getByTitle(anyString())).thenReturn(mockExistingDocument);

        // when
        assertThrows(
                CreateDocumentException.class,
                () -> {
                    sut.createNewDocument(
                            new CreateDocumentRequest(
                                    "아무말",
                                    "내용",
                                    UUID.randomUUID().toString(),
                                    LocalDateTime.now()
                            )
                    );
                }
        );
    }
}
