package dev.app.bootifulwork;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/books")
  public ResponseEntity<Page<Book>> getBooks(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

    return ResponseEntity.ok(bookService.getAggregatedBooks(page, size));
  }
}
