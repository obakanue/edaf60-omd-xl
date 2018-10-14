package gui;
import java.util.*;

import java.awt.Color;

public class CurrentLabel extends ColoredLabel implements Observer {
    private CurrentCell currentCell;

    public CurrentLabel() {
        super("A1", Color.WHITE);


    }

    @Override
    public void update(Observable observable, Object object){
        setText(currentCell.toString());
    }
}



