package model;
import model.expr.Environment;
import model.expr.Expr;

public class ExprCell implements Cell {

    private Expr expr;

    public ExprCell (Expr expr){
        this.expr = expr;
    }

    public double cellValue(Environment env){
        return expr.value(env);
    }

    public String toString(){
        return expr.toString();
    }


}
