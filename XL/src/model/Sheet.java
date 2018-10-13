package model;

import model.expr.Environment;

import java.util.Map;
import java.util.TreeMap;
//Lyssna på hela modellen -> lyssna på sheets
public class Sheet implements Environment {
    Map<String, Cell> cellMap;

    public Sheet(Map<String, Cell> cellMap){
        this.cellMap = new TreeMap<String, Cell>();
    }

}
