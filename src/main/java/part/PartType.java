package part;

public enum PartType {
    PN,
    PART_NAME,
    VENDOR,
    QTY,
    SHIPPED,
    RECEIVE,
    DEFAULT;

    public static PartType getType(String type) {
        switch (type) {
            case "PN":
                return PN;
            case "PART_NAME":
                return PART_NAME;
            case "VENDOR":
                return VENDOR;
            case "QTY":
                return QTY;
            case "SHIPPED":
                return SHIPPED;
            case "RECEIVE":
                return RECEIVE;
        }
        return DEFAULT;
    }

}
