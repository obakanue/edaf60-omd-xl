package model;

import util.XLException;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class CellFactory {
    public Cell cell(Sheet sheet, String addr, String value) {
        if (value.startsWith("#")) {
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
