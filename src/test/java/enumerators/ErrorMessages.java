package enumerators;

public enum ErrorMessages {
    MURDER("murder"),
    HIJACK("hijack"),
    BLACKMAIL("blackmail"),
    CAR_ACCIDENT("car accident"),
    ROBBERY("robbery");

    private String xpathValue;

    ErrorMessages(String xpathValue){
        this.xpathValue = xpathValue;
    }

    public String getXpathValue() {
        return xpathValue;
    }
}
