package az.idrak.derbytest.entity.home;

import az.idrak.derbytest.dto.EnumDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public enum RoomType {

    DINING_ROOM(1, "DINING_ROOM"),
    BEDROOM(2, "BEDROOM"),
    KITCHEN(3, "KITCHEN"),
    BATHROOM(4, "BATHROOM"),
    LIVING_ROOM(5, "LIVING_ROOM"),
    MUD_ROOM(6, "MUD_ROOM"),
    HOME_GYM(7, "HOME_GYM"),
    HOME_OFFICE(8, "HOME_OFFICE"),
    LAUNDRY_ROOM(9, "LAUNDRY_ROOM"),
    ATTIC(10, "ATTIC"),
    GAMES_ROOM(11, "GAMES_ROOM"),
    HOME_THEATER(12, "HOME_THEATER"),
    LIBRARY(13, "LIBRARY"),
    FAMILY_ROOM(14, "FAMILY_ROOM"),
    NURSERY(15, "NURSERY"),
    BASEMENT(16, "BASEMENT"),
    CLOSET(17, "CLOSET"),
    PANTRY(18, "PANTRY"),
    PLAYROOM(19, "PLAYROOM"),
    FOYER(20, "FOYER"),
    GARAGE(21, "GARAGE"),
    HALF_BATH(22, "HALF_BATH"),
    HALLWAY(23, "HALLWAY");

    private final Integer id;

    private final String name;

    private RoomType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static RoomType lookUp(Integer id) throws Exception {
        for (RoomType roomType : values()) {
            if (roomType.id.equals(id)) {
                return roomType;
            }
        }
        throw new Exception();
    }

    public static List<EnumDTO> all() throws Exception {
        List<EnumDTO> list = new ArrayList<>();
        for (RoomType roomType : values()) {
            EnumDTO dto = new EnumDTO();
            dto.setId(roomType.getId());
            dto.setName(roomType.getName());
            list.add(dto);
        }
        return list;
    }

    public static RoomType of(Integer id) {
        return Stream.of(RoomType.values())
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
