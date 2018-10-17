package gui;

import model.Sheet;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {
    Sheet sheet;
    public StatusLabel(Sheet sheet) {
        super("", Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText(sheet.getStatus());
    }
}