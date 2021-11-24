package ru.javabegin.training.goldman.interfaces.gameobjects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.MovingDirection;

import javax.swing.*;

public interface MovingObject {
    void move(MovingDirection direction);

    void getMoveResult(AbstractGameObject objectInNewCoordinate);

    ImageIcon getIconLeft();

    ImageIcon getIconUp();

    ImageIcon getIconDown();

    ImageIcon getIconRight();

}
