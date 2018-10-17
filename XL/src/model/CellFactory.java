package model;

import util.XLException;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class CellFactory extends Sheet {

    public static Cell cell(/*Sheet sheet, String addr, */String value) {
        if (value.length() == 0) {
            return null;
        } else if (value.startsWith("#")) {
            //sheet.add(addr, new CommentCell(value));   // bryter mot SRP
            return new CommentCell(value);
        } else {
            try {
                Expr expr = new ExprParser().build(value);
                //sheet.add(addr, new ExprCell(expr));  // bryter mot SRP
                return new ExprCell(expr);
            } catch (IOException e) {
                throw XLException.CELLBUILD_ERROR;
            }
        }
    }
}
