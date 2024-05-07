package az.idrak.derbytest.entity.home;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "building")
@Getter
@Setter
@NoArgsConstructor
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_building")
    @SequenceGenerator(name = "seq_building", sequenceName = "seq_building_id", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "building__home__fk"))
    private Home home;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<Floor> floors;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<Room> rooms;

}
