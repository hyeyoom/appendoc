package wiki.appendoc.appendocapi.app.wiki.application.dto;

import java.time.LocalDateTime;

public class ReadDocumentQueryResult {

    private final String title;
    private final String content;
    private final LocalDateTime createdDate;

    public ReadDocumentQueryResult(String title, String content, LocalDateTime createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
