package berkaybarisalgunLibrarymanagement.repository;

import berkaybarisalgunLibrarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,int> {

    findByName(String name);
}
