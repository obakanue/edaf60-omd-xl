package model;
package util;
import model.expr.Environment;

public class BombCell extends Cell {

    public BombCell((Sheet sheet, String address){
        super(sheet, address);
    }

    public double cellValue(Environment env){
        throw XLException;
    }
}
