package ru.javabegin.training.goldman.enums;

import java.io.Serializable;

public enum GameObjectType  implements Serializable {


    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDMAN(1),
    NOTHING(-1);


    private  int indexPriority;

    GameObjectType(int indexPriority) {
        this.indexPriority = indexPriority;
    }

    public int getIndexPriority() {
        return indexPriority;
    }
}
