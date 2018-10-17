package util;

import model.Cell;
import model.CellFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, String> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String address = string.substring(0, i);
                String value = string.substring(i + 1);
                map.put(address, value);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
