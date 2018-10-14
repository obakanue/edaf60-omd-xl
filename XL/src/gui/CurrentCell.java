package gui;

import java.awt.*;
import java.util.*;

public class CurrentCell extends Observable{
    private SlotLabel currentLabel;
    private String address;

    public CurrentCell(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
    	this.address = address;
    }


}
