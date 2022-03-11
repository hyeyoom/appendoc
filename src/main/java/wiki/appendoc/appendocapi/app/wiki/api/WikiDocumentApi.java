package wiki.appendoc.appendocapi.app.wiki.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.appendoc.appendocapi.app.wiki.api.dto.QueryDocumentResponse;
import wiki.appendoc.appendocapi.app.wiki.api.dto.WriteDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.api.dto.WriteDocumentResponse;
import wiki.appendoc.appendocapi.app.wiki.application.CreateDocumentService;
import wiki.appendoc.appendocapi.app.wiki.application.QueryDocumentService;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentResponse;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQuery;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQueryResult;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wiki")
public class WikiDocumentApi {

    private final CreateDocumentService createDocumentService;
    private final QueryDocumentService queryDocumentService;

    @PostMapping
    public WriteDocumentResponse writeDocument(@RequestBody WriteDocumentRequest request) {
        final CreateDocumentResponse response =
                createDocumentService
                        .createNewDocument(new CreateDocumentRequest(
                                request.getTitle(),
                                request.getContent(),
                                "not implemented",
                                LocalDateTime.now()
                        ));
        return new WriteDocumentResponse(response.getDocumentId());
    }

    @GetMapping("/{title}")
    public QueryDocumentResponse queryDocument(@PathVariable String title) {
        final ReadDocumentQueryResult result =
                queryDocumentService
                        .readDocument(new ReadDocumentQuery(title));
        return new QueryDocumentResponse(
                result.getTitle(),
                result.getContent(),
                result.getCreatedDate()
        );
    }
}
