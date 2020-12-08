package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ISBN;

    @Column
    private String title;

    @Column
    private Float price;

    @Column
    private LocalDateTime publishedDate;

    @Column
    private Integer nbrPfPage;

    @ManyToOne(targetEntity = Book.class)
    private Category category;

}
