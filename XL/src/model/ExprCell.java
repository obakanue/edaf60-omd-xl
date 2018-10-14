package model;
import expr.*;

public class ExprCell implements Cell {

    private Expr expr;

    public ExprCell (Sheet sheet, String address, Expr expr){
        this.expr = expr;
        this.sheet = sheet;
    }

    public double cellValue(Environment env){
        return expr.value(env);
    }


}
