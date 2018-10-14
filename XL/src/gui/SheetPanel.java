package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;



public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentCell current) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, current));
    }
}