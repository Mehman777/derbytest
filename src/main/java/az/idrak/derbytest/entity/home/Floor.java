package az.idrak.derbytest.entity.home;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "floor")
@Getter
@Setter
@NoArgsConstructor
public class Floor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_floor")
    @SequenceGenerator(name = "seq_floor", sequenceName = "seq_floor_id", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "floor__home__fk"))
    private Home home;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "floor__building__fk"))
    private Building building;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY)
    private List<Room> rooms;
}
