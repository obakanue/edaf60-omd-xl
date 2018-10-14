package model;

import model.expr.Environment;

public interface Cell {

    double cellValue(Environment env);
}
