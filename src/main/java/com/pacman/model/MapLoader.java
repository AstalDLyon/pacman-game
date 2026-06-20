package com.pacman.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class MapLoader {

    private MapLoader() {} // É uma utility class, com metodos estaticos

    public static List<Block> load(String  resourcePath) throws IOException {
        List<Block> blocks = new ArrayList<>();

        try (InputStream input = MapLoader.class.getResourceAsStream(resourcePath)) {
            if (input == null) {
                throw new IOException("Mapa não  encontrado: " + resourcePath);
            }
            String content = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            String[] lines = content.split("\n");

            for(int row = 0; row < lines.length; row++){
                String line = lines[row];
                for (int col = 0; col < line.length(); col++) {
                    char tile = line.charAt(col);
                    Position position = new Position(col, row);
                    blocks.add(parseTile(tile, position));
                }
            }
        }
        return blocks;
    }
    private static Block parseTile(char tile, Position position){
        return switch (tile) {
            case 'X' -> new Block.Wall(position);
            case 'O' -> new Block.Food(position);
            case 'P' -> new Block.PacMan(position, Direction.RIGHT);
            case 'r' -> new Block.Ghost(position, Direction.LEFT, GhostType.BLINKY);
            case 'b' -> new Block.Ghost(position, Direction.UP, GhostType.INKY);
            case 'p' -> new Block.Ghost(position, Direction.DOWN, GhostType.PINKY);
            case 'o' -> new Block.Ghost(position, Direction.RIGHT, GhostType.CLYDE);
            default -> null; // espaço vazio, sem bloco
        };
    }
}
