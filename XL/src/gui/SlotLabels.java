package gui;

import model.Sheet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private int cols;
    private Sheet sheet;
    private CurrentCell currentCell;
    private int prevInd;

    public SlotLabels(int rows, int cols, CurrentCell currentCell) {
        super(rows + 1, cols);
        this.cols = cols;
        this.sheet = sheet;
        this.currentCell = currentCell;
        currentCell.addObserver(this);
        sheet.addObserver(this);
        
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String address = ch + String.valueOf(row);
                SlotLabel label = new SlotLabel("" + col + row, this);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
    }
    
    

    public CurrentCell getCurrentCell(){
    	return currentCell;
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
