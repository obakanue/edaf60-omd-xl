package gui;

import model.Sheet;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class SlotLabel extends ColoredLabel implements MouseListener{
    private String address;
    private XL xl;
    private CurrentCell currentCell;
    private Sheet sheet;

    public SlotLabel(XL xl) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.xl = xl;
        sheet = xl.getSheet();
        currentCell = xl.getCurrentCell();
        this.address = address;

    }


    public String toString(){
        return address;
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