package ru.javabegin.training.goldman.objects.creators;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.objects.*;

public class GameObjectCreator {
    private static GameObjectCreator instance;

    public static GameObjectCreator getInstance() {
        if (instance == null) {
            instance = new GameObjectCreator();
        }
        return instance;
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        AbstractGameObject obj;
        switch (type) {
            case NOTHING:
                obj = new Nothing(coordinate);
                break;
            case GOLDMAN:
                obj = new GoldMan(coordinate);
                break;
            case WALL:
                obj = new Wall(coordinate);
                break;
            case MONSTER:
                obj = new Monster(coordinate);
                break;

            case TREASURE:
                obj = new Treasure(coordinate);
                break;
            case EXIT:
                obj = new Exit(coordinate);
                break;
            default:
                throw  new IllegalArgumentException("Can't create obkct type"  + type);

        }
        return obj;


    }
}
