package dungeon;

public class Player {
    public byte posX = 0;
    public byte posY = 0;
    private Map map;

    public Player(byte x, byte y, Map map) {
        posX = x;
        posY = y;
        this.map = map;
    }

    public void move(String s) {
        switch (s) {
            case "w" -> posY--;
            case "s" -> posY++;
            case "a" -> posX--;
            case "d" -> posX++;
            default -> System.out.println("?");
        }
    }
}
