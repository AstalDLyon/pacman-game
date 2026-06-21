package com.pacman.view;

import com.pacman.controller.GameController;
import com.pacman.model.Block;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    private static final int TILE_SIZE = 32; // para mudar o zoom do jogo é só mudar aqui

    private final GameController controller;

    public GamePanel(GameController controller) {
        this.controller = controller;
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        for (Block block : controller.getBlocks()) {
            int x = block.position().x() * TILE_SIZE;
            int y = block.position().y() * TILE_SIZE;

            switch (block) {
                case Block.Wall wall -> {
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                }
                case Block.Food food -> {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + TILE_SIZE / 3, y + TILE_SIZE / 3, TILE_SIZE, TILE_SIZE / 3);
                }
                case Block.PacMan pacMan -> {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x, y, TILE_SIZE, TILE_SIZE);
                }
                case Block.Ghost ghost ->  {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                }
                case Block.PowerUp powerUp -> {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + TILE_SIZE / 6, y + TILE_SIZE / 6, TILE_SIZE * 2 / 3, TILE_SIZE * 2 / 3);
                }
            }
        }
    }

}
