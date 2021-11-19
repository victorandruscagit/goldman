package ru.javabegin.training.goldman.objects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.abstracts.AbstractMovingObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;

public class GoldMan extends AbstractMovingObject {
    private int totalScore = 0;
    private int turnsNumber = 0;



    public GoldMan(Coordinate coordinate) {
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);
        super.setIconDown(getImageIcon("/ru/javabegin/training/goldman/images/goldman_down.png"));
        super.setIconUp(getImageIcon("/ru/javabegin/training/goldman/images/goldman_up.png"));
        super.setIconLeft(getImageIcon("/ru/javabegin/training/goldman/images/goldman_left.png"));
        super.setIconRight(getImageIcon("/ru/javabegin/training/goldman/images/goldman_right.png"));
        super.setIcon(super.getIconUp());
    }

    @Override
    public void move(MovingDirection direction) {

    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {

    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }
}
