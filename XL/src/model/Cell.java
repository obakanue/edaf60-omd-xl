package model;

import model.expr.Environment;

public interface Cell {

    double value(Environment env);
    String toString();
}
