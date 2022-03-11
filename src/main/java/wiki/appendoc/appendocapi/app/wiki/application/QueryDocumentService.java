package wiki.appendoc.appendocapi.app.wiki.application;

import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQuery;
import wiki.appendoc.appendocapi.app.wiki.application.dto.ReadDocumentQueryResult;

public interface QueryDocumentService {

    ReadDocumentQueryResult readDocument(ReadDocumentQuery query);
}
