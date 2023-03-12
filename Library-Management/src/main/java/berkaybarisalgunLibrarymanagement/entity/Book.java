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
    private int page_count;
    @Column(nullable = false)
    private String language;
    @Column
    private String genre;
    @Column(nullable = false, columnDefinition = "varchar(255) default 'unspecified'")
    private String location_on_shelf;

    @Column(nullable = false)
    private int stock; // "stock" area


}
