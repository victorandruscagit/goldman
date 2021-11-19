package ru.javabegin.training.goldman.objects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.interfaces.GameMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public abstract class AbstractGameMap implements GameMap, Serializable {

    private static final long serialVersionId = 1L;
    private int width;
    private int height;

    private boolean isExitExists;
    private boolean isGoldmanExists;

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects =
            new EnumMap<GameObjectType, ArrayList<AbstractGameObject>>(GameObjectType.class);


    public AbstractGameObject getPriorityObject(AbstractGameObject first, AbstractGameObject second) {
        return (first.getType().getIndexPriority() > second.getType().getIndexPriority()) ? first : second;

    }

    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));

    }

    public ArrayList<AbstractGameObject> getList(GameObjectType type) {
        return typeObjects.get(type);
    }

    public boolean isValidMap() {
        return isGoldmanExists && isExitExists;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isExitExists() {
        return isExitExists;
    }

    public void setExitExists(boolean exitExists) {
        isExitExists = exitExists;
    }

    public boolean isGoldmanExists() {
        return isGoldmanExists;
    }

    public void setGoldmanExists(boolean goldmanExists) {
        isGoldmanExists = goldmanExists;
    }
}
