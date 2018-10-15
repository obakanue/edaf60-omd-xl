package gui;

import model.Sheet;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, CurrentCell currentCell, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String address = ch + String.valueOf(row);
                SlotLabel label = new SlotLabel(address, currentCell);
                add(label);
                labelList.add(label);
            }
        }

        sheet.addObserver(this);

        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentCell.set(firstLabel);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
