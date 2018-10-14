package gui;

import java.awt.*;
import java.util.*;

public class CurrentCell extends Observable{
    private SlotLabel currentLabel;

    public void set(SlotLabel currentLabel){
        this.currentLabel = currentLabel;
        setChanged();
        notifyObservers();
        addObserver(currentLabel);
    }

    public void clearCurrent(){
        currentLabel.setBackground(Color.WHITE);
    }

}
