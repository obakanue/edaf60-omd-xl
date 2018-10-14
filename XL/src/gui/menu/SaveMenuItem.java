package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.PrintStream;

class SaveMenuItem extends OpenMenuItem {

    private Sheet sheet;

    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        PrintStream out = new PrintStream(path);
        Set<Entry<String, Cell>> entries = sheet.getEntries();
        for(Entry<String, Cell> index : entries){
            //vill ha address nedan
            out.print(index.);
            out.print('=');
            //vill ha value nedan om comment string
            out.println(index.);
        }
        flush();
        close();

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}