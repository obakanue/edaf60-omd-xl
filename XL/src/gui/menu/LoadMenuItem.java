package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import model.CellFactory;
import model.Sheet;
import model.Cell;
import util.XLBufferedReader;
import util.XLException;


class LoadMenuItem extends gui.menu.OpenMenuItem {

    private CellFactory loadCellFactory;
    private Sheet sheet;


    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
        loadCellFactory = new CellFactory();
    }

    protected void action(String path) {
        XL loaded = new XL(xl);
        XLBufferedReader reader = null;
        try {
            reader = new XLBufferedReader(path);
        } catch (FileNotFoundException e) {
            statusLabel.setText("Unable to load file " + e.getMessage());
        }
        Map<String, Cell> loadMap = new TreeMap<>();
        try{
            for (Map.Entry<String, Cell> entry : xl.getSheet().getMap().entrySet()) {
                loadMap.put(entry.getKey(), entry.getValue());
            }
            reader.load(loadMap);
        }catch (XLException e){
            //TODO
        }
        loaded.load(loadMap);
    }

    protected int openDialog (JFileChooser fileChooser){
        return fileChooser.showOpenDialog(xl);
    }
}