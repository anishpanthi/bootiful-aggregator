package dev.app.bootifulwork;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Anish Panthi
 */
public interface BookARepository extends JpaRepository<BookA, Long> {

  @Query("SELECT a FROM BookA a ORDER BY a.id")
  List<BookA> findBooks(Pageable pageable);
}
