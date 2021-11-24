package ru.javabegin.training.goldman.objects.creators;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.objects.maps.DBGameMap;
import ru.javabegin.training.goldman.objects.maps.FSGameMap;

public class MapCreator {
    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type) {
        AbstractGameMap map = null;
        switch (type) {
            case DB: {
                map = new DBGameMap();
                break;
            }
            case FS: {
                map = new FSGameMap();
                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);
        }
        return map;
    }
}
