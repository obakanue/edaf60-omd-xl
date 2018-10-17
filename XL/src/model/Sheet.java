package model;
import model.expr.Environment;
import util.XLException;

import java.util.*;

public class Sheet extends Observable implements Environment {
    private Map<String, Cell> cellMap;

    public Sheet(){
        cellMap = new TreeMap<>();
    }

    public Optional<Cell> getCell(String address){
        return Optional.ofNullable(cellMap.get(address));
    }

    public void add(String address, String value){
        Cell cell = CellFactory.cell(value);
        if(!isRecursive(address, cell)){
            cellMap.put(address, cell);
        }
        setChanged();
        notifyObservers();
    }

    public void clearAll(){
        cellMap = new TreeMap<>();
        setChanged();
        notifyObservers();
    }

    public void load(Map<String, String> newCellMap){
        for (Map.Entry<String, String> entry : newCellMap.entrySet()) {
            this.add(entry.getKey(), entry.getValue());
        }
    }

    public void startObserving(){
    }

    public Map<String, Cell> getMap() {
        return cellMap;
    }

    public void clearCell(String address){
        cellMap.remove(address);
        setChanged();
        notifyObservers();
    }

    public double value(String address){
        return getCell(address).map(x -> x.cellValue(this)).orElse(0.0);
    }


    private boolean isRecursive(String address, Cell cell){
        Cell temp = cellMap.get(address);
        BombCell bomb = new BombCell();
        cellMap.put(address, bomb);
        try{
            cell.cellValue(this);
        }catch (XLException e) {
            cellMap.put(address, temp);
            return true;
        }
        cellMap.put(address, temp);
        return false;
    }

}