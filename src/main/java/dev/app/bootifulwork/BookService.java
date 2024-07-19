package dev.app.bootifulwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@RequiredArgsConstructor
public class BookService {

  private final BookARepository bookARepository;

  private final BookBRepository bookBRepository;

  public Page<Book> getAggregatedBooks(int page, int size) {
    List<Book> aggregatedBooks = new ArrayList<>();
    int offsetA = 0, offsetB = 0, fetchedRecords = 0;

    while (fetchedRecords < size) {
      var booksA = this.getBooksA(offsetA, size);
      var booksB = this.getBooksB(offsetB, size);

      // TODO: First check booksA and booksB are not empty. If it is empty, break the loop and
      // TODO: return
      List<Book> finalAggregatedBooks = aggregatedBooks;
      booksA.forEach(
          book ->
              finalAggregatedBooks.add(new Book(book.getId(), book.getTitle(), book.getSource())));
      booksB.forEach(
          book ->
              finalAggregatedBooks.add(new Book(book.getId(), book.getTitle(), book.getSource())));

      offsetA += booksA.size();
      offsetB += booksB.size();

      fetchedRecords += booksA.size() + booksB.size();
    }

    aggregatedBooks =
        aggregatedBooks.stream()
            .sorted(Comparator.comparing(Book::id))
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());

    return new PageImpl<>(aggregatedBooks, PageRequest.of(page, size), fetchedRecords);
  }

  List<BookA> getBooksA(int offset, int size) {
    Pageable pageable = PageRequest.of(offset / size, size);
    return bookARepository.findBooks(pageable);
  }

  List<BookB> getBooksB(int offset, int size) {
    Pageable pageable = PageRequest.of(offset / size, size);
    return bookBRepository.findBooks(pageable);
  }
}
