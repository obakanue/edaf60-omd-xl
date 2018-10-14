package gui;

import java.util.*;

public class CurrentCell extends Observable{
    private SlotLabel current;

    public void set(SlotLabel current){
        this.current = current;
        setChanged();
        notifyObservers();
        addObserver(current);
    }


}
