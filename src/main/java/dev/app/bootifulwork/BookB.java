package dev.app.bootifulwork;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Anish Panthi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_b")
public class BookB {
  @Id
  @Column(name = "ID")
  Long id;

  @Column(name = "TITLE")
  String title;

  @Column(name = "SOURCE")
  String source;
}
