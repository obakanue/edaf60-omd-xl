package gui;

import model.Sheet;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class SlotLabel extends ColoredLabel implements MouseListener{
    private String address;
    private CurrentCell currentCell;

    public SlotLabel(String address, CurrentCell currentCell) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentCell = currentCell;
        this.address = address;
    }

    public SlotLabel(CurrentCell currentCell){
        super("                    ", Color.WHITE);
        this.address = currentCell.getAddress();
    }

    public void setCurrent(CurrentCell currentCell){
        this.currentCell = currentCell;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public void mousePressed(MouseEvent e){
        currentCell.clearColor();
        this.setBackground(Color.YELLOW);
        currentCell.set(this);
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