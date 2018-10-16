package gui.menu;

import gui.StatusLabel;
import gui.XL;
import javafx.scene.control.Cell;

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
				out.print(entries.getKey());
				out.print('=');
				// Kommer att bli problem med nedan (båda har toString)
				out.println(entries.getValue().toString());
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