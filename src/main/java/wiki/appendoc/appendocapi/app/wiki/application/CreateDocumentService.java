package wiki.appendoc.appendocapi.app.wiki.application;

import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentRequest;
import wiki.appendoc.appendocapi.app.wiki.application.dto.CreateDocumentResponse;

public interface CreateDocumentService {

    CreateDocumentResponse createNewDocument(CreateDocumentRequest request);
}
