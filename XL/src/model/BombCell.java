package model;
import model.expr.Environment;
import util.XLException;

public class BombCell implements Cell {

    public double cellValue(Environment env){
        throw XLException.RECURSIVECELL_ERROR;
    }
}
