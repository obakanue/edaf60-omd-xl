package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;



class LoadMenuItem extends OpenMenuItem {

    private CellFactory() loadCellFactory;
    private Sheet sheet;


    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
        loadCellFactory = new CellFactory();
        sheet = new Sheet();
    }

    protected void action(String path) throws FileNotFoundException {
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            TreeMap<String, Cell> loadSheet = new TreeMap<String, Cell>();
            while (ready()){
                String line = readLine();
                int seperate = line.indexOf('=');
                String address = line.substring(0,address);
                String value = line.substring(address + 1);
                loadSheet.put(address, loadCellFactory.cell(sheet, value));

            }

        }catch
            catch (FileNotFoundException e) {
            statusLabel.setText("Unable to load file " + e);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}