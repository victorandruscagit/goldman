package ru.javabegin.training.goldman.objects.maps;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.objects.Coordinate;
import ru.javabegin.training.goldman.objects.creators.GameObjectCreator;

import java.io.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FSGameMap extends AbstractGameMap {
    @Override
    public boolean loadMap(Object source) {
        File file = new File(source.toString());
        if (!file.exists()) {
            throw new IllegalArgumentException("must exists");
        }
        try {
            setExitExists(false);
            setGoldmanExists(false);
            setHeight(getLineCount(file));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String strLine = reader.readLine();
            setName(strLine.split(",")[0]);

            int y = 0;
            int x = 0;
            while ((strLine = reader.readLine()) != null) {
                x = 0;
                for (String string : strLine.split(", ")) {
                    createGameObject(string, new Coordinate(x, y));
                    x++;
                }
                y++;


            }


        } catch (Exception e) {

        }
        return false;
    }

    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1;


        } catch (IOException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return lineCount;
    }

    public void createGameObject(String str, Coordinate coordinate) {
        GameObjectType gameObjectType = GameObjectType.valueOf(str.toUpperCase());
        AbstractGameObject gameObject = GameObjectCreator.getInstance().createObject(gameObjectType, coordinate);
        addGameObject(gameObject);
        if (gameObject.getType() == GameObjectType.EXIT) {
            setExitExists(true);
        } else if (gameObject.getType() == GameObjectType.GOLDMAN) {
            setGoldmanExists(true);
        }


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
