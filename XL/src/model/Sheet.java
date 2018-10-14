package model;

import model.expr.Environment;
import java.io.*;

import java.util.Map;
import java.util.TreeMap;
//Lyssna på hela modellen -> lyssna på sheets
public class Sheet extends Observable implements Environment {
    private Map<String, Cell> cellMap;

    public Sheet(){
        cellMap = new TreeMap<String, Cell>();
    }

    public Cell getCell(String address){
        if(cellMap.contains(address)){
            return cellMap.get(address);
        }else {
            return cellMap.get(address);
        }
    }

    public void put(String address, Cell cell){
        cellMap.put(address, cell);
    }

    @Override
    public double value(String name){
        return getCell(name).cellValue(this);
    }

}
