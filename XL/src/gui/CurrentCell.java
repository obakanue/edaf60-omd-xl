package gui;

import java.awt.*;
import java.util.*;

public class CurrentCell extends Observable {
    private SlotLabel slotLabel;

    public CurrentCell() {
    }

    public String getAddress() {
        return slotLabel.getAddress();
    }

    public void set(SlotLabel slotLabel) {
        this.slotLabel = slotLabel;
        setChanged();
        notifyObservers();
    }

    public void setColor() {
        if (slotLabel.getBackground() == Color.WHITE) {
            slotLabel.setBackground(Color.YELLOW);
        } else {
            slotLabel.setBackground(Color.WHITE);
        }
    }

}
