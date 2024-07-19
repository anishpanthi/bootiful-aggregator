package dev.app.bootifulwork;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Anish Panthi
 */
public interface BookBRepository extends JpaRepository<BookB, Long> {

  @Query("SELECT b FROM BookB b ORDER BY b.id")
  List<BookB> findBooks(Pageable pageable);

}
