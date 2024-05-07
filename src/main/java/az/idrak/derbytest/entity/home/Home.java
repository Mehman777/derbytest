package az.idrak.derbytest.entity.home;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "home")
@Getter
@Setter
@NoArgsConstructor
public class Home implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_home")
    @SequenceGenerator(name = "seq_home", sequenceName = "seq_home_id", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 32)
    private String name;

    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
    private List<Room> rooms;

    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
    private List<Building> buildings;

    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
    private List<Floor> floors;
}
