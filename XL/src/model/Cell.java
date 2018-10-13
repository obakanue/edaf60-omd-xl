package model;

import model.expr.Environment;

public interface Cell {

    public abstract double cellValue(Environment env);
}
