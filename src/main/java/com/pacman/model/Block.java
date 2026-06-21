package com.pacman.model;

public sealed interface Block {

    Position position();

    record Wall(Position position) implements Block {}

    record Food(Position position) implements Block {}

    record PowerUp(Position position) implements Block {}

    record PacMan(Position position, Direction direction) implements Block {}

    record Ghost(Position position, Direction direction, GhostType type) implements Block {}
}
