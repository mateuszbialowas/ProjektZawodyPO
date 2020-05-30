package def;

public class InvalidIndexException extends Exception {
    int invalidIndex;

    InvalidIndexException(int invalidIndex) {
        this.invalidIndex = invalidIndex;
    }

    public int InvalidIndex() {
        return invalidIndex;
    }
}
