package com.pacman.model;

public record Position(int x, int y) {
    public Position move (int deltaX, int deltaY) {
        return new Position(x + deltaX, y + deltaY);
        // Teste de pull
    }
}
