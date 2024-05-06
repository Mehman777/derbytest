package az.idrak.derbytest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
public class TestTable implements Serializable {

    @Id
    private Long id;


    private String name;


}
