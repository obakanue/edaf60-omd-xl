package model;

import util.XLException;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class CellFactory extends Sheet {

    public static Cell cell(String value) {
        if (value.length() == 0) {
            return null;
        } else if (value.startsWith("#")) {
            return new CommentCell(value);
        } else {
            try {
                Expr expr = new ExprParser().build(value);
                return new ExprCell(expr);
            } catch (IOException e) {
                throw XLException.CELLBUILD_ERROR;
            }
        }
    }
}
