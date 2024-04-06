package dungeon.chunks;

public class Chunk {
    final String[] chunk;
    public Chunk(String[] chunk) {
        this.chunk = chunk;
    }
    public String[] getChunk(boolean isPlayerHere) {
        String[] chunk1 = chunk;
        if (isPlayerHere) {
            chunk1[4] = chunk1[4].replace('^', '0');
        } else {
            chunk1[4] = chunk1[4].replace('^', ' ');
        }
        return chunk1;
    }
}
