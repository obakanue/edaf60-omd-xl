package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import model.CellFactory;
import model.Sheet;
import model.Cell;




class LoadMenuItem extends OpenMenuItem {

    private CellFactory loadCellFactory;
    private Sheet sheet;


    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
        loadCellFactory = new CellFactory();
        sheet = new Sheet();
    }

    protected void action(String path) throws FileNotFoundException {
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            TreeMap<String, Cell> loadSheet = new TreeMap<>();
            while (file.ready()) {
                String line = file.readLine();
                int seperate = line.indexOf('=');
                String address = line.substring(0, seperate);
                String value = line.substring(seperate + 1);
                loadSheet.put(address, loadCellFactory.cell(sheet, address, value));

            }

        } catch (Exception e) {
            statusLabel.setText("Unable to load file " + e);
        }
    }
    protected int openDialog (JFileChooser fileChooser){
        return fileChooser.showOpenDialog(xl);
    }
}