package gui;

import model.Cell;
import model.CommentCell;
import model.Sheet;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private Sheet sheet;
    private int rows;
    private int cols;

    public SlotLabels(int rows, int cols, CurrentCell currentCell, Sheet sheet) {
        super(rows + 1, cols);
        this.sheet = sheet;
        this.rows = rows;
        this.cols = cols;
        sheet.addObserver(this);
        labelList = new ArrayList<>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String address = ch + String.valueOf(row);
                SlotLabel label = new SlotLabel(address, currentCell);
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        currentCell.setColor();
                        currentCell.set(label);
                        currentCell.setColor();
                    }
                });
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentCell.set(firstLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        Map<String, Cell> tempMap = sheet.getMap();
        for (SlotLabel sl : labelList) {
            if (!tempMap.containsKey(sl.getAddress())) {
                sl.setText("");
            } else{
                Cell tempCell = tempMap.get(sl.getAddress());
                if(tempCell instanceof CommentCell){
                    String text = tempCell.toString();
                    sl.setText(text.substring(1));
                }else{
                    sl.setText(Double.toString(sheet.value(sl.getAddress())));
                }
            }
        }
        /*for (Map.Entry<String, Cell> entry : tempMap.entrySet()) {
            String address = entry.getKey();
            Cell cell = entry.getValue();
            for (SlotLabel sl : labelList) {
                if (sl.getAddress() == address) {
                    if (cell instanceof CommentCell) {
                        String cellString = cell.toString();
                        sl.setText(cellString.substring(1));
                    } else {
                        sl.setText(Double.toString(sheet.value(entry.getKey())));
                    }
                }
            }
        }*/
    }
}
