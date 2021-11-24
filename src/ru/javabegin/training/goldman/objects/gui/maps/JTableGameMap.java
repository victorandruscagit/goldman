package ru.javabegin.training.goldman.objects.gui.maps;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.interfaces.gamemap.DrawableMap;
import ru.javabegin.training.goldman.objects.Coordinate;
import ru.javabegin.training.goldman.objects.Nothing;
import ru.javabegin.training.goldman.objects.Wall;
import ru.javabegin.training.goldman.objects.creators.MapCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class JTableGameMap implements DrawableMap {

    private JTable jTableMap = new JTable();
    
    private AbstractGameMap gameMap;
    
    private String[] columnNames;
    // объекты для отображения на карте будут храниться в двумерном массиве типа AbstractGameObject
    // каждый элемент массива будет обозначаться согласно текстовому представлению объекта как описано в GameObjectType
    private AbstractGameObject[][] mapObjects;

    public JTableGameMap(LocationType type, Object source) {
        jTableMap.setEnabled(false);
        jTableMap.setSize(new java.awt.Dimension(300, 300));
        jTableMap.setRowHeight(26);
        jTableMap.setRowSelectionAllowed(false);
        jTableMap.setShowHorizontalLines(false);
        jTableMap.setShowVerticalLines(false);
        jTableMap.setTableHeader(null);
        jTableMap.setUpdateSelectionOnSort(false);
        jTableMap.setVerifyInputWhenFocusTarget(false);

        gameMap = MapCreator.getInstance().createMap(type);
        gameMap.loadMap(source);

        
        updateObjectsArray();
    }


   
    private void fillEmptyMap(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapObjects[y][x] = new Nothing(new Coordinate(x, y));
            }
        }
    }

  
    private void updateObjectsArray() {

        mapObjects = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];

        fillEmptyMap(gameMap.getWidth(), gameMap.getHeight());

        // потом заполнить массив объектами		
        for (AbstractGameObject gameObj : gameMap.getAllGameObjects()) {
            if (!gameObj.getType().equals(GameObjectType.NOTHING)) {// пустоты не добавляем, т.к. они уже добавились когда мы вызвали метод fillEmptyMap()
                int y = gameObj.getCoordinate().getY();
                int x = gameObj.getCoordinate().getX();
                if (!(mapObjects[y][x] instanceof Nothing) & // если в этих координатах уже есть какой то объект, отличный от пустоты и стены
                        !(mapObjects[y][x] instanceof Wall)) {
                    AbstractGameObject tmpObj = mapObjects[y][x];
                    mapObjects[y][x] = gameMap.getPriorityObject(tmpObj, gameObj);
                } else {
                    mapObjects[y][x] = gameObj;// проставить объект на карте согласно его координатам
                }
            }
        }
    }

    @Override
    public boolean drawMap() {

        try {
            // присваиваем пустоту всем заголовкам столбцов, чтобы у таблицы не было заголовоков, а то некрасиво смотрится
            columnNames = new String[gameMap.getWidth()];

            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }


            // игровое поле будет отображаться в super без заголовков столбцов
            jTableMap.setModel(new DefaultTableModel(mapObjects, columnNames));


            // вместо текста в ячейках таблицы устанавливаем отображение картинки
            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }    

    @Override
    public Component getMap() {
        return jTableMap;
    }
}
