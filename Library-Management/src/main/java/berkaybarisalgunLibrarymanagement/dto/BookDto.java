package berkaybarisalgunLibrarymanagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
