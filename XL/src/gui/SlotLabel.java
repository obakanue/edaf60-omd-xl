package gui;



import java.awt.Color;


public class SlotLabel extends ColoredLabel {
    private String address;

    public SlotLabel(String address, CurrentCell currentCell) {
        super("                    ", Color.WHITE, RIGHT);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}