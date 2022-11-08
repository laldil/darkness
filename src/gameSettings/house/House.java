package gameSettings.house;

public class House {
    private String name;
    private Room firstRoom;

    public String getName() {
        return name;
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    private House(HouseBuilder houseBuilder){
        this.name = houseBuilder.name;
        this.firstRoom = houseBuilder.firstRoom;
    }

    public static class HouseBuilder{
        private String name;
        private Room firstRoom;

        public HouseBuilder(String name){
            this.name = name;
        }

        public HouseBuilder setFirstRoom(Room firstRoom) {
            this.firstRoom = firstRoom;
            return this;
        }
        public House build(){
            return new House(this);
        }
    }
}
