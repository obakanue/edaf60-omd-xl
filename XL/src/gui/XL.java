package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import gui.menu.XLMenuBar;

import model.Sheet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private XLList xlList;
    private Sheet sheet;
    private StatusLabel statusLabel;
    private CurrentCell currentCell;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        this.sheet = new Sheet();
        this.statusLabel = new StatusLabel(sheet);
        this.currentCell = new CurrentCell();
        xlList.add(this);
        counter.increment();
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, currentCell, sheet);
        JPanel statusPanel = new StatusPanel(statusLabel, currentCell);
        Editor editor = new Editor(sheet, currentCell);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public Sheet getSheet() {
        return sheet;
    }

    public CurrentCell getCurrentCell() {
        return currentCell;
    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public void load(Map<String, String> map, String path) {
        sheet.load(map, path);
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }
}