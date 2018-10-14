package model;

import util.XLException;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class CellFactory {
    public void cell(Sheet sheet, String addr, String value) {
    	if (value.length() == 0) {
			sheet.clearCell(addr);
    	}
			else if (value.startsWith("#")) {
        	sheet.add(addr, new CommentCell(value));
        } else {
            try {
                Expr expr = new ExprParser().build(value);
                sheet.add(addr, new ExprCell(expr));
            } catch (IOException e) {
                throw XLException.CELLBUILD_ERROR;
            }
        }
    }
}
