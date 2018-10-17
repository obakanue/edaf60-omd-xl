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

public class Editor extends JTextField implements Observer {
    private CellFactory cellFactory;
    private Sheet sheet;
    private CurrentCell currentCell;

    public Editor(Sheet sheet, CurrentCell currentCell) {
        this.sheet = sheet;
        this.currentCell = currentCell;
        cellFactory = new CellFactory();
        setBackground(Color.WHITE);
        currentCell.addObserver(this);
        addActionListener(e -> {
            String value = getText();
            sheet.add(currentCell.getAddress(), value);
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