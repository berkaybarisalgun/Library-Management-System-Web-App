package berkaybarisalgunLibrarymanagement.entity;


import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int pageCount;
    @Column(nullable = false)
    private String language;
    @Column
    private String genre;
    @Column(nullable = false)
    private String locationOnShelf;
    @Column(nullable = false)
    private int stock; // "stock" area


}
