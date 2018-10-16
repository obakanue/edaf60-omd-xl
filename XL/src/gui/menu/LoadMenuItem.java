package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import model.CellFactory;
import model.Sheet;
import model.Cell;




class LoadMenuItem extends gui.menu.OpenMenuItem {

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
            //IllegalArgumentException - If sz is <= 0, hur få in
            try {
            while (file.ready()) {
                //IllegalArgumentException
                String line = file.readLine();
                int separator = line.indexOf('=');
                String address = line.substring(0, separator);
                String value = line.substring(separator + 1);
                loadSheet.put(address, loadCellFactory.cell(sheet, address, value));
            }catch (IOException e){

                }
            for (Map.Entry<String, Cell> entry : loadSheet.entrySet()){
                 sheet.add(entry.getKey(), entry.getValue());
            }
            //ha något som ger nytt sheet i sheet, metod?
            //updateralabels?

        } catch (FileNotFoundException e) {
            statusLabel.setText("Unable to load file " + e.getMessage());
        }
    }

    protected int openDialog (JFileChooser fileChooser){
        return fileChooser.showOpenDialog(xl);
    }
}