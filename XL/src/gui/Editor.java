package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javax.swing.JTextField;

import model.Sheet;
import model.Cell;
import model.CellFactory;
import gui.CurrentCell;
import util.XLException;

public class Editor extends JTextField implements Observer {
    private Sheet sheet;
    private CurrentCell currentCell;

    public Editor(Sheet sheet, CurrentCell currentCell) {
        this.sheet = sheet;
        this.currentCell = currentCell;
        setBackground(Color.WHITE);
        currentCell.addObserver(this);
        addActionListener(e -> {
            String value = getText();
            if(!value.isEmpty()) {
                sheet.add(currentCell.getAddress(), value);
                sheet.clearStatus();
            }
        });
    }

    @Override
    public void update(Observable observable, Object object) {
        Optional<Cell> opCell = sheet.getCell(currentCell.getAddress());
        if (opCell.isPresent()) {
            Cell cell = opCell.get();
            setText(cell.toString());
        } else {
            setText("");
        }
    }
}