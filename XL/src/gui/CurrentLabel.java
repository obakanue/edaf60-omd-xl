package gui;
import java.util.*;

import java.awt.Color;

public class CurrentLabel extends ColoredLabel implements Observer {
    private CurrentCell current;
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

    @Override
    public void update(Observable observable, Object object){
        setText(current.toString());
    }
}



