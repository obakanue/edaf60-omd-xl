package gui.menu;

import model.Cell;
import model.CommentCell;
import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.PrintStream;
import java.util.Map;
import model.Sheet;

class SaveMenuItem extends gui.menu.OpenMenuItem {

	private Sheet sheet;

	public SaveMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Save");
		this.sheet = sheet;
	}

	protected void action(String path) throws FileNotFoundException {
		try {
			Map<String, Cell> tempMap = sheet.getMap();
			PrintStream out = new PrintStream(path);
			for (Map.Entry<String, Cell> entry : tempMap.entrySet()) {
				out.print(entry.getKey());
				out.print('=');
				Cell tempCell = entry.getValue();
				if (tempCell instanceof CommentCell) {
					String cellString = tempCell.toString();
					out.println(cellString.substring(1, cellString.length()));
				} else {
					out.println(Double.toString(sheet.value(entry.getKey())));
				}
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			statusLabel.setText("Unable to save file " + e);
		}

	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}