package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

import model.Sheet;
import model.Cell;
import model.CommentCell;
import model.ExprCell;
import gui.CurrentCell;
import model.expr.Expr;
import model.expr.ExprParser;

public class Editor extends JTextField implements Observer {
    private Sheet sheet;
    private CurrentCell currentCell;

    public Editor(Sheet sheet, CurrentCell currentCell) {
        this.sheet = sheet;
        this.currentCell = currentCell;

        setBackground(Color.WHITE);
        currentCell.addObserver(this);

        addActionListener(e -> {
            Cell cell;
            String value = getText();
            if (value.length() > 0 && value.startsWith("#")) {
                cell = new CommentCell(value);
                sheet.add(currentCell.getAddress(), cell);
            } else if (value.length() > 0 && !value.startsWith("#")) {
                Expr expr = new ExprParser().build(value);
                cell = new ExprCell(sheet, currentCell.getAddress(), expr);
                sheet.add(currentCell.getAddress(), cell);
            } else
                sheet.clearCell(currentCell.getAddress());
        });
    }

    @Override
    public void update(Observable observable, Object object) {
        getText();
    }
}