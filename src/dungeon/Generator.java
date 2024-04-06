package dungeon;


import java.util.Random;


public class Generator implements ISettings {
    private byte[][] DUNGEON_STRUCTURES = new byte[17][17];
    private byte[][] DUNGEON_STRUCTURES_ROTATE = new byte[17][17];
    protected final byte SIZE = (byte) this.DUNGEON_STRUCTURES.length;
    static Random r = new Random();

    private int getVoid() {
        int v = 0;
        for (byte y = 0; y != SIZE; y++) {
            for (byte x = 0; x != SIZE; x++) {
                if (DUNGEON_STRUCTURES[y][x] == 0) {
                    v++;
                }
            }
        }
        return v;
    }

    public Generator() {
        int void0 = 0;
        int void1 = 0;
        byte exit = 0;
        byte e = 0;

        genRandomStructures();
        byte[][] ANCIENT_LABYRINTH_STRUCTURES_IN_WORK = DUNGEON_STRUCTURES;
        byte[][] ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK = DUNGEON_STRUCTURES_ROTATE;

        while (true) {

            void0 = getVoid();
            if (void0 == void1) {
                exit++;
            } else {
                exit = 0;
            }
            if (exit >= 4) {
                System.out.println(e);
                return;
            }
            void1 = getVoid();
            DUNGEON_STRUCTURES = ANCIENT_LABYRINTH_STRUCTURES_IN_WORK;
            DUNGEON_STRUCTURES_ROTATE = ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK;
            e++;
            for (byte y = 0; y != SIZE; y++) {
                for (byte x = 0; x != SIZE; x++) {
                    // get structures
                    byte structure = DUNGEON_STRUCTURES[y][x];
                    byte structureRotate = DUNGEON_STRUCTURES_ROTATE[y][x];

                    byte upYStructure = 0;
                    byte upYStructureRotate = 0;
                    if (y > 0) {
                        upYStructure = DUNGEON_STRUCTURES[y - 1][x];
                        upYStructureRotate = DUNGEON_STRUCTURES_ROTATE[y - 1][x];
                    }

                    byte belowYStructure = 0;
                    byte belowYStructureRotate = 0;
                    if (y < SIZE - 1) {
                        belowYStructure = DUNGEON_STRUCTURES[y + 1][x];
                        belowYStructureRotate = DUNGEON_STRUCTURES_ROTATE[y + 1][x];
                    }

                    byte backStructure = 0;
                    byte backStructureRotate = 0;
                    if (x > 0) {
                        backStructure = DUNGEON_STRUCTURES[y][x - 1];
                        backStructureRotate = DUNGEON_STRUCTURES_ROTATE[y][x - 1];
                    }

                    byte forwardStructure = 0;
                    byte forwardStructureRotate = 0;
                    if (x < SIZE - 1) {
                        forwardStructure = DUNGEON_STRUCTURES[y][x + 1];
                        forwardStructureRotate = DUNGEON_STRUCTURES_ROTATE[y][x + 1];
                    }

                    // gen
                    if (structure == CROSSROADS_ID || structure == ENTRY_ID || structure == BOSS_ID) {
                        if (x < SIZE - 1) {
                            if (forwardStructure == 0) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x + 1] = WAY_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x + 1] = 1;
                            } else if (forwardStructure == WAY_ID && forwardStructureRotate == 2) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x + 1] = CROSSROADS_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x + 1] = 1;
                            }
                        }

                        if (x > 0) {
                            if (backStructure == 0) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x - 1] = WAY_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x - 1] = 1;
                            } else if (backStructure == WAY_ID && backStructureRotate == 2) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x - 1] = CROSSROADS_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x - 1] = 1;
                            }
                        }

                        if (y > 0) {
                            if (upYStructure == 0) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y - 1][x] = WAY_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y - 1][x] = 2;
                            } else if (upYStructure == WAY_ID && upYStructureRotate == 1) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y - 1][x] = CROSSROADS_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y - 1][x] = 1;
                            }
                        }

                        if (y < SIZE - 1) {
                            if (belowYStructure == 0) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y + 1][x] = WAY_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y + 1][x] = 2;
                            } else if (belowYStructure == WAY_ID && belowYStructureRotate == 1) {
                                ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y + 1][x] = CROSSROADS_ID;
                                ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y + 1][x] = 1;
                            }
                        }
                    }

                    if (upYStructure == WAY_ID && upYStructureRotate == 2) {
                        if (structure == 0) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = WAY_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 2;
                        } else if (structure == WAY_ID && structureRotate == 1) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = CROSSROADS_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        }
                    }

                    if (belowYStructure == WAY_ID && belowYStructureRotate == 2) {
                        if (structure == 0) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = WAY_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 2;
                        } else if (structure == WAY_ID && structureRotate == 1) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = CROSSROADS_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        }
                    }

                    if (backStructure == WAY_ID && backStructureRotate == 1) {
                        if (structure == 0) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = WAY_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        } else if (structure == WAY_ID && structureRotate == 2) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = CROSSROADS_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        }
                    }

                    if (forwardStructure == WAY_ID && forwardStructureRotate == 1) {
                        if (structure == 0) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = WAY_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        } else if (structure == WAY_ID && structureRotate == 2) {
                            ANCIENT_LABYRINTH_STRUCTURES_IN_WORK[y][x] = CROSSROADS_ID;
                            ANCIENT_LABYRINTH_STRUCTURES_ROTATE_IN_WORK[y][x] = 1;
                        }
                    }
                }
            }

        }
    }
    protected void genRandomStructures() {
        for (byte y = 0; y != SIZE; y++) {
            for (byte x = 0; x != SIZE; x++) {
                DUNGEON_STRUCTURES[y][x] = 0;
                DUNGEON_STRUCTURES_ROTATE[y][x] = 0;
            }
        }
        DUNGEON_STRUCTURES[8][8] = ENTRY_ID;
        DUNGEON_STRUCTURES_ROTATE[8][8] = ROTATE_MAX[ENTRY_ID - 1];
        for (byte q = 0; q != 8; q++) {
            boolean foundRandom = false;
            byte x = 0;
            byte y = 0;
            while (!foundRandom) {
                x = (byte) r.nextInt(16);
                y = (byte) r.nextInt(16);
                foundRandom = DUNGEON_STRUCTURES[y][x] == 0;
            }
            DUNGEON_STRUCTURES[y][x] = CROSSROADS_ID;
            DUNGEON_STRUCTURES_ROTATE[y][x] = ROTATE_MAX[CROSSROADS_ID - 1];
        }
        boolean foundRandom = false;
        byte x = 0;
        byte y = 0;
        while (!foundRandom) {
            x = (byte) r.nextInt(16);
            y = (byte) r.nextInt(16);
            if (x + 1 <= SIZE - 1 && y + 1 <= SIZE - 1) {
                foundRandom =
                        DUNGEON_STRUCTURES[y][x] == 0 &&
                        DUNGEON_STRUCTURES[y][x + 1] == 0 &&
                        DUNGEON_STRUCTURES[y + 1][x] == 0 &&
                        DUNGEON_STRUCTURES[y + 1][x + 1] == 0 &&
                        x >= 12 || x <= 4 &&  y >= 12 || y <= 4;
            }
        }
        DUNGEON_STRUCTURES[y][x] = BOSS_ID;
        DUNGEON_STRUCTURES[y][x + 1] = BOSS_ID;
        DUNGEON_STRUCTURES[y + 1][x] = BOSS_ID;
        DUNGEON_STRUCTURES[y + 1][x + 1] = BOSS_ID;
    } // Gen Random Structures

    public byte[][][] get() {
        return new byte[][][] {DUNGEON_STRUCTURES, DUNGEON_STRUCTURES_ROTATE};
    }

}
