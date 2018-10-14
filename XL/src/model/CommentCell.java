package model;
import model.expr.Environment;

public class CommentCell implements Cell {
private String comment;

    public CommentCell(String comment){
        this.comment = comment;
    }

    public double cellValue(Environment env){
        return 0;
    }
}
