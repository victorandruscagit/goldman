package ru.javabegin.training.goldman.objects.maps;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;

public class DBGameMap  extends AbstractGameMap {
    @Override
    public boolean loadMap(Object source) {
        return false;
    }

    @Override
    public boolean saveMap(Object source) {
        return false;
    }

    @Override
    public boolean drawMap() {
        return false;
    }
}
