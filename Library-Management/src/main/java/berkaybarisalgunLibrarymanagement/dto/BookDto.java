package berkaybarisalgunLibrarymanagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

    private int id;
    private String title;
    private String author;
    private int pageCount;
    private String language;
    private String genre;
    private String locationOnShelf;
    private int stock; // "stock" area
}
