package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

import model.Sheet;
import model.Cell;
import model.CellFactory;
import model.CommentCell;
import model.ExprCell;
import gui.CurrentCell;
import model.expr.Expr;
import model.expr.ExprParser;

public class Editor extends JTextField implements Observer {
	private CellFactory cellFactory;

	public Editor(Sheet sheet, CurrentCell currentCell) {
		cellFactory = new CellFactory();
		setBackground(Color.WHITE);
		currentCell.addObserver(this);
		addActionListener(e -> {
			String value = getText();
			if (value.length() == 0) {
				sheet.clearCell(currentCell.getAddress());
			} else {
				cellFactory.cell(sheet, currentCell.getAddress(), value);
			}
		});
	}

	@Override
	public void update(Observable observable, Object object) {
		getText();
		//TODO implement update()
	}
}