package dungeon;

public class Map {
    public byte[][] map;
    public byte[][] mapRotate;


    public Map(byte[][] map, byte[][] mapRotate) {
        if (map.length == mapRotate.length) {
            this.map = map;
            this.mapRotate = mapRotate;
        } else {
            System.out.println("ты дурак?");
        }
    }
}
