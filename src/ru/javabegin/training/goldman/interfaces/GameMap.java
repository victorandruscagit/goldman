package ru.javabegin.training.goldman.interfaces;


public interface GameMap {
    int getHeight();

    int getWidth();

    boolean createMap();

    boolean loadMap();

    boolean saveMap();

    boolean drawMap();

    int getTimeLimit();
}
