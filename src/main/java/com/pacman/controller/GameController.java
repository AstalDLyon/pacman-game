package com.pacman.controller;

import com.pacman.model.Block;
import com.pacman.model.MapLoader;

import java.io.IOException;
import java.util.List;

public class GameController {

    private static final int POWER_UP_DURATION_TICKS = 480; // 8 segundos a 60 ticks/seg

    private final List<Block> blocks;

    private int powerUpTicksRemaining = 0;

    public GameController(String mapResourcePath) throws IOException {
        this.blocks = MapLoader.load(mapResourcePath);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public boolean isPowerUpActive() {
        return powerUpTicksRemaining > 0;
    }

    public void activatePowerUp() {
        powerUpTicksRemaining = POWER_UP_DURATION_TICKS;
    }

    public void tick() {
        if (powerUpTicksRemaining > 0) {
            powerUpTicksRemaining--;
        }
    }
}
