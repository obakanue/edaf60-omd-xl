package util;

public class XLException extends RuntimeException {
    //
    // Här måste diverse exceptions skrivas like so
    public static final XLException RECURSIVECELL_ERROR = new XLException("One slot cannot be used multiple times");
    public XLException(String message) {
        super(message);
    }
}