package dungeon;

public class Player {
    byte posX = 0;
    byte posY = 0;

    public Player(byte x, byte y) {
        posX = x;
        posY = y;
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
