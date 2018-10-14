package model;

import model.expr.Environment;

public abstract class Cell {
    Sheet sheet;
    String address;

    public Cell(Sheet sheet, String address){
        this.sheet = sheet;
        this.address = address;
    }
    public abstract double cellValue(Environment env);
}
