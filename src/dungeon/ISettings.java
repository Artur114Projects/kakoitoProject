package dungeon;

public interface ISettings {

    byte WAY_ID = 1;
    byte WAY_ROTATE_MAX = 2;
    byte[] WAY_MIXING = new byte[] {};

    byte TURN_ID = 2; // поворот
    byte TURN_CHANCE = 2;
    byte TURN_ROTATE_MAX = 4;
    byte[] TURN_MIXING = new byte[] {};

    byte FORK_ID = 3; // развилка
    byte FORK_CHANCE = 3;
    byte FORK_ROTATE_MAX = 4;
    byte[] FORK_MIXING = new byte[] {};

    byte CROSSROADS_ID = 4;
    byte CROSSROADS_CHANCE = 4;
    byte CROSSROADS_ROTATE_MAX = 1;
    byte[] CROSSROADS_q = new byte[] {};

    byte END_ID = 5;
    byte END_CHANCE = 1;
    byte END_ROTATE_MAX = 4;
    byte[] END_MIXING = new byte[] {};

    byte ENTRY_ID = 6;
    byte ENTRY_ROTATE_MAX = 1;
    byte[] ENTRY_MIXING = new byte[] {};

    byte BOSS_ID = 7;
    byte BOSS_CHANCE = 8;
    byte BOSS_ROTATE_MAX = 1;
    byte[] BOSS_MIXING = new byte[] {};
    byte BOSS_N_ID = -7;

    byte[] ROTATE_MAX = new byte[] {WAY_ROTATE_MAX, TURN_ROTATE_MAX, FORK_ROTATE_MAX, CROSSROADS_ROTATE_MAX, END_ROTATE_MAX, ENTRY_ROTATE_MAX, BOSS_ROTATE_MAX};
}
