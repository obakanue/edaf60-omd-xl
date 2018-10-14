package model;

import model.expr.Environment;
import java.util.*;


//Lyssna på hela modellen -> lyssna på sheets
public class Sheet extends Observable implements Environment {
    private Map<String, Cell> cellMap;

    public Sheet(){
        cellMap = new TreeMap<>();
    }

    public Cell getCell(String address){
        if(cellMap.containsKey(address)){
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
