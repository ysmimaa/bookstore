package entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@Data
@Entity
@Table(name = "CATEGORY")
public class Category extends IdEntity {

    @Column
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private Collection<Book> books=new ArrayList<>();
}
