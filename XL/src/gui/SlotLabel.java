package gui;

import model.Sheet;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class SlotLabel extends ColoredLabel {
    private String address;
    private CurrentCell currentCell;

    public SlotLabel(String address, CurrentCell currentCell) {
        super("                    ", Color.WHITE, RIGHT);
        this.currentCell = currentCell;
        this.address = address;
    }

    public SlotLabel(CurrentCell currentCell) {
        super("                    ", Color.WHITE);
        this.address = currentCell.getAddress();
    }

    public void setCurrent(CurrentCell currentCell) {
        this.currentCell = currentCell;
    }

    public String getAddress() {
        return address;
    }
}