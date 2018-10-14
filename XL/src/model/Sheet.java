package model;

import model.expr.Environment;
import java.util.*;


//Lyssna på hela modellen -> lyssna på sheets
public class Sheet extends Observable implements Environment {
    private Map<String, Cell> cellMap;

    public Sheet(){
        cellMap = new TreeMap<>();
    }

    public Optional<Cell> getCell(String address){
        return Optional.ofNullable(cellMap.get(address));
    }

    public void put(String address, Cell cell){
        cellMap.put(address, cell);
    }

    @Override
    public double value(String name){
        return getCell(name).map(x -> x.cellValue(this)).orElse(0.0);
    }

}
