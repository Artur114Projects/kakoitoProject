package dungeon.chunks;

public class Chunk {
    final String[] chunk;
    public Chunk(String[] chunk) {
        this.chunk = chunk;
    }
    public String[] getChunk(boolean isPlayerHere) {
        String[] chunk1 = chunk;
        String s;
        if (isPlayerHere) {
            s = chunk1[4].replace('^', '0');
        } else {
            s = chunk1[4].replace('^', ' ');
        }
        return new String[] {chunk1[0], chunk1[1], chunk1[2], chunk1[3], s, chunk1[5],  chunk1[6], chunk1[7], chunk1[8], chunk1[9]};
    }
}
