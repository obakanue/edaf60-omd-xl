package gui;

import java.util.*;

import java.awt.Color;

public class CurrentLabel extends ColoredLabel implements Observer {
    private CurrentCell currentCell;

    public CurrentLabel(CurrentCell currentCell) {
        super(currentCell.getAddress(), Color.WHITE);
        this.currentCell = currentCell;
        this.currentCell.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object object) {
        setText(currentCell.getAddress());
    }

}



