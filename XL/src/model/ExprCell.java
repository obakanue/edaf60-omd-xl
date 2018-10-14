package model;
import model.expr.Environment;
import model.expr.Expr;

public class ExprCell implements Cell {

    private Expr expr;

    public ExprCell (Sheet sheet, String addr, String value){
        this.expr = expr;
    }

    public double cellValue(Environment env){
        return expr.value(env);
    }


}
