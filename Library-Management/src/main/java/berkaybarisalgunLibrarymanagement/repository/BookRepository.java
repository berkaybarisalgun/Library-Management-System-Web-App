package berkaybarisalgunLibrarymanagement.repository;

import berkaybarisalgunLibrarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

    void findBytitle(String title);
}
