package model;

import model.expr.Environment;
import util.XLException;

import java.util.*;

public class Sheet extends Observable implements Environment {
    private Map<String, Cell> cellMap;
    String status;

    public Sheet() {
        cellMap = new TreeMap<>();
        status = "";
    }

    public Optional<Cell> getCell(String address) {
        return Optional.ofNullable(cellMap.get(address));
    }

    public void add(String address, String value) {
        Cell cell = CellFactory.cell(value);
        if (!isRecursive(address, cell)) {
            try{
                cellMap.put(address, cell);
            }catch(NullPointerException e) {
                status = e.toString();
            }
        }
        setChanged();
        notifyObservers();
    }

    public String getStatus(){
        return status;
    }

    public void clearStatus(){
        status = "";
    }

    public void clearAll() {
        status = "     All cleared";
        cellMap = new TreeMap<>();
        setChanged();
        notifyObservers();
    }

    public void load(Map<String, String> newCellMap, String path) {
        status = "   loaded " + path;
        for (Map.Entry<String, String> entry : newCellMap.entrySet()) {
            try{
                this.add(entry.getKey(), entry.getValue());
            }catch(XLException e){
                status = e.toString();
            }
        }
        setChanged();
        notifyObservers();
    }

    public Map<String, Cell> getMap() {
        return cellMap;
    }

    public void clearCell(String address) {
        cellMap.remove(address);
        setChanged();
        notifyObservers();
    }

    public double value(String address) {
        return getCell(address).map(x -> x.cellValue(this)).orElse(0.0);
    }

    public boolean isPresent(String address){
        return cellMap.containsKey(address);
    }


    private boolean isRecursive(String address, Cell cell) {
        Cell temp = cellMap.get(address);
        BombCell bomb = new BombCell();
        cellMap.put(address, bomb);
        try {
            cell.cellValue(this);
        } catch (XLException e) {
            status = e.toString();
            cellMap.put(address, temp);
            return true;
        }catch(NullPointerException e){
            status = e.toString();
            cellMap.put(address,temp);
            return true;
        }
        cellMap.put(address, temp);
        return false;
    }

}