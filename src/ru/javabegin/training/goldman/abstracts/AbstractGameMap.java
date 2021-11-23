package ru.javabegin.training.goldman.abstracts;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.interfaces.GameMap;
import ru.javabegin.training.goldman.objects.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public abstract class AbstractGameMap implements GameMap, Serializable {

    private static final long serialVersionId = 1L;
    private int width;
    private int height;
    private String name;
    private int timeLimit;

    private boolean isExitExists;
    private boolean isGoldmanExists;

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();

    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<GameObjectType, ArrayList<AbstractGameObject>>(GameObjectType.class);


    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public AbstractGameObject getPriorityObject(AbstractGameObject first, AbstractGameObject second) {
        return (first.getType().getIndexPriority() > second.getType().getIndexPriority()) ? first : second;

    }

    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tempList = typeObjects.get(gameObject.getType());
        if (tempList == null) {
            tempList = new ArrayList<>();
        }
        tempList.add(gameObject);

        typeObjects.put(gameObject.getType(), tempList);
        gameObjects.put(gameObject.getCoordinate(), gameObject);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getTimeLimit() {
        return timeLimit;
    }
}
