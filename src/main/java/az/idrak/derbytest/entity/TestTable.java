package az.idrak.derbytest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
public class TestTable implements Serializable {

    @Id
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testTable2_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "Test__Test2__fk"))
    private TestTable2 testTable2;


}
