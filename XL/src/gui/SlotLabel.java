package gui;

import model.Sheet;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
    private String address;
    private CurrentCell currentCell;

    public SlotLabel(CurrentCell currentCell, String address) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentCell = currentCell;
        this.address = address;

    }


    public String toString(){
        return address;
    }

    @Override
    public void update(Observable o, Object arg) {

    }


    @Override
    public void mousePressed(MouseEvent e){
        currentCell.setAddress(address);
        this.setBackground(Color.YELLOW);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}