package com.pacman;

import com.pacman.controller.GameController;
import com.pacman.view.GamePanel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::startGame);
    }

    private static void startGame() {
        try{

            GameController controller = new GameController("/maps/level1.map");
            GamePanel gamePanel = new GamePanel(controller);

            JFrame frame = new JFrame("Pac-Man");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(gamePanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            Timer gameLoop = new Timer(1000 / 60, e -> {
                controller.tick();
                gamePanel.repaint();
            });
            gameLoop.start();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o mapa: " + e.getMessage());
        }
    }
}
