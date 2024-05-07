package az.idrak.derbytest.entity.home;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_room")
    @SequenceGenerator(name = "seq_room", sequenceName = "seq_room_id", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "home_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "room__home__fk"))
    private Home home;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "room__building__fk"))
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "room__floor__fk"))
    private Floor floor;

    @Column(name = "type_id")
    private RoomType type;
}
