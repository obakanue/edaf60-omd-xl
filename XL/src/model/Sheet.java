package model;
import model.expr.Environment;
import java.util.*;

public class Sheet extends Observable implements Environment{
    private Map<String, Cell> cellMap;

    public Sheet(){
        cellMap = new TreeMap<>();
    }

    public Optional<Cell> getCell(String address){
        return Optional.ofNullable(cellMap.get(address));
    }

    public void add(String address, Cell cell){
        cellMap.put(address, cell);
        setChanged();
        notifyObservers();
    }

    public void clearAll(){
        cellMap = new TreeMap<>();
        setChanged();
        notifyObservers();
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
}