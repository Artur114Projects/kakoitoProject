package main;

import dungeon.Compiler;
import dungeon.Generator;
import dungeon.Map;
import dungeon.Player;


import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        var generator = new Generator();
        byte[][] map = new byte[3][3];
        byte[][] mapR = new byte[3][3];
        var mapC = new Map(map, mapR);
//        int rx = random.nextInt(18);
//        int ry = random.nextInt(18);
        int rx = 9;
        int ry = 9;
        Player player = new Player((byte) 0, (byte) 0, mapC);
        while (true) {

            if (rx > 15 || rx < 1 || ry > 15 || ry < 1) {
                return;
            } else {
                if (player.posY > 2) {
                    player.posY = 0;
                    ry += 3;
                } else
                if (player.posX > 2) {
                    player.posX = 0;
                    rx += 3;
                } else
                if (player.posY < 0) {
                    player.posY = 2;
                    ry -= 3;
                } else
                if (player.posX < 0) {
                    player.posX = 2;
                    rx -= 3;
                }

                for (int y = ry - 1; y <= ry + 1; y++) {
                    for (int x = rx - 1; x <= rx + 1; x++) {
                        if (x - (rx - 1) != -1 && y - (ry - 1) != -1) {
                            map[y - (ry - 1)][x - (rx - 1)] = generator.get()[0][y][x];
                            mapR[y - (ry - 1)][x - (rx - 1)] = generator.get()[1][y][x];
                        }
                    }
                }

                Compiler c = new Compiler(map, mapR, player);
                c.SOUT();
            }

            player.move(scan.next());
        }
    }
}