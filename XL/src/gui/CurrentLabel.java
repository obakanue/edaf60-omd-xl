package gui;
import java.util.*;

import java.awt.Color;

public class CurrentLabel extends ColoredLabel implements Observer {
    private CurrentCell currentCell;

    public CurrentLabel(CurrentCell currentCelll) {
        super("A1", Color.WHITE);
        this.currentCell = currentCell;
        currentCell.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object object){
        setText(currentCell.toString());
    }
}



