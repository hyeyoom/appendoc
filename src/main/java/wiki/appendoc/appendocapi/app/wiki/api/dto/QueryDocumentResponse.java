package wiki.appendoc.appendocapi.app.wiki.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryDocumentResponse {

    private String title;
    private String content;
    private LocalDateTime createdDate;
}
