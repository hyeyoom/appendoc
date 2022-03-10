package wiki.appendoc.appendocapi.app.wiki.application.dto;

import java.time.LocalDateTime;

public class CreateDocumentRequest {

    private final String title;
    private final String content;
    private final String authorId;
    private final LocalDateTime createdDate;

    public CreateDocumentRequest(String title, String content, String authorId, LocalDateTime createdDate) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
