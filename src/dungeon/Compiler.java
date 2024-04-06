package dungeon;

import dungeon.chunks.Chunk;
import dungeon.chunks.IDungeonChunks;

public class Compiler implements ISettings, IDungeonChunks{
    byte[][] dungeonMap = new byte[][] {
        {4, 1, 1},
        {4, 1, 4},
        {4, 1, 4},
    };

    byte[][] dungeonRotateMap = new byte[][] {
            {1, 1, 2},
            {1, 1, 1},
            {1, 1, 1},
    };

    String[] dungeonMapInString = new String[30];
    public Compiler(byte[][] dungeonMap, byte[][] dungeonRotateMap, Player player) {
        for (byte y = 0; y != dungeonMap.length; y++) {
            for (byte x = 0; x != dungeonMap[y].length; x++) {
                int toMax = (10 + (10 * y));
                int toMin = (10 * y);
                if (dungeonMap[y][x] == CROSSROADS_ID && dungeonRotateMap[y][x] == 1) {
                    set(toMin, toMax, CROSSROADS, player.posX == x && player.posY == y);
                }
                if (dungeonMap[y][x] == ENTRY_ID && dungeonRotateMap[y][x] == 1) {
                    set(toMin, toMax, ENTRY, player.posX == x && player.posY == y);
                }
                if (dungeonMap[y][x] == WAY_ID && dungeonRotateMap[y][x] == 1) {
                    set(toMin, toMax, WAY_R1, player.posX == x && player.posY == y);
                }
                if (dungeonMap[y][x] == WAY_ID && dungeonRotateMap[y][x] == 2) {
                    set(toMin, toMax, WAY_R2, player.posX == x && player.posY == y);
                }
                if (dungeonMap[y][x] == 0 && dungeonRotateMap[y][x] == 0) {
                    set(toMin, toMax, VOID, player.posX == x && player.posY == y);
                }
            }
        }
    }
    private void set(int toMin, int toMax, Chunk S, boolean playerHere) {
        byte q = 0;
        String[] SS = S.getChunk(playerHere);

        for (int i = toMin; i != toMax; i++) {
            if (dungeonMapInString[i] != null) {
                dungeonMapInString[i] = dungeonMapInString[i] + SS[q];
            } else {
                dungeonMapInString[i] = SS[q];
            }
            q++;
        }
    }

    public void SOUT() {
        for (byte i = 0; i!= dungeonMapInString.length; i++) {
            System.out.println(dungeonMapInString[i]);
        }
    }
}
