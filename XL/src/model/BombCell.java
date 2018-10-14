package model;
import model.expr.Environment;
import util.XLException;

public class BombCell extends Cell {

    public BombCell(Sheet sheet, String address){
        super(sheet, address);
    }

    public double cellValue(Environment env){
        throw XLException.RECURSIVECELL_ERROR;
    }
}
