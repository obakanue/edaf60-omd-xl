package model;
import model.expr.Expr;
import model.expr.Environment;

public class ExprCell implements Cell {

    private Expr expr;

    public ExprCell (Expr expr){
        this.expr = expr;
    }

    public double cellValue(Environment env){
        return expr.value(env);
    }

}
