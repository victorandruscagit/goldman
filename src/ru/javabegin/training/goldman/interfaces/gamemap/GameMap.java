package ru.javabegin.training.goldman.interfaces.gamemap;


public interface GameMap {
    int getHeight();

    int getWidth();


    boolean loadMap(Object source);

    boolean saveMap(Object source);

    boolean drawMap();

    int getTimeLimit();
}
