package com.pacman.view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public final class SpriteSheet {

    private final BufferedImage sheet;
    private final int tileSize;

    public SpriteSheet(String resourcePath, int tileSize) throws IOException {
        try (InputStream input = SpriteSheet.class.getResourceAsStream(resourcePath)) {
            if (input == null) {
                throw new IOException("Sprite sheet não encontrado: " + resourcePath);
            }
            this.sheet = ImageIO.read(input);
        }
        this.tileSize = tileSize;
    }

    public BufferedImage getTile(int column, int row) {
        return sheet.getSubimage(
                column * tileSize,
                row * tileSize,
                tileSize,
                tileSize
        );
    }
}
