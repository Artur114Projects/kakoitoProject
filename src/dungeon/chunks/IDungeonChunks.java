package dungeon.chunks;

public interface IDungeonChunks {
    Chunk CROSSROADS = new Chunk(new String[] {
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "_____________|     |_____________",
            "                ^                ",
            "--------------     --------------",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
    });

    Chunk WAY_R1 = new Chunk(new String[] {
            "                                 ",
            "                                 ",
            "                                 ",
            "_________________________________",
            "                ^                ",
            "---------------------------------",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
    });

    Chunk WAY_R2 = new Chunk( new String[]{
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |  ^  |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
    });

    Chunk ENTRY = new Chunk( new String[]{
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "_____________|     |_____________",
            "                ^                ",
            "--------------     --------------",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
            "             |     |             ",
    });

    Chunk VOID = new Chunk( new String[]{
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
            "                                 ",
    });
}
