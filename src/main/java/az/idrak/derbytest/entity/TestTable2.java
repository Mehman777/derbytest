package az.idrak.derbytest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "test2")
@Getter
@Setter
@NoArgsConstructor
public class TestTable2 implements Serializable {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "testTable2", fetch = FetchType.LAZY)
    private List<TestTable> testTables;



}