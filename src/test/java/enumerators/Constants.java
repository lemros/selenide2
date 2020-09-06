package enumerators;

public class Constants {

    public static final String ID_IDENTIFICATOR = "id";
    public static final String CSS_IDENTIFICATOR = "css";
    public static final String NAME_IDENTIFICATOR = "name";
    public static final String CLASS_IDENTIFICATOR = "class";
    public static final String XPATH_IDENTIFICATOR = "xpath";
    public static final String TEXT_IDENTIFICATOR = "text";
    public static final String VALUE_IDENTIFICATOR = "value";

    public enum BROWSER {
        CHROME("Google Chrome"),
        MOZILLA("Mozilla Firefox"),
        EDGE("EDGE"),
        OPERA("Opera"),
        SAFARI("Safari"),
        EXPLORER("Internet Explorer");

        public String value;

        private BROWSER(String value) {
            this.value = value;
        }
    }

    public enum DOMENS {
        PROD_PRIVATE_MOJA("https://moja.csob.sk"),
        DEV_PRIVATE_MOJA("https://d-moja.csob.sk"),
        INT_PRIVATE_MOJA("https://i-moja.csob.sk"),
        INT_PRIVATE_PILOT("https://i-pilot-moja.csob.sk"),
        ACC_PRIVATE_MOJA("https://a-moja.csob.sk"),
        ACC_PRIVATE_PILOT("https://a-pilot-moja.csob.sk");

        public String value;

        private DOMENS(String value) {
            this.value = value;
        }

        private String DOMENS(){
            return value;
        }

    }


    public enum LINKS {
        SEPA_PAYMENT("https://i-moja.csob.sk"),
        LOGIN("");

        public String value;

        private LINKS(String value) {
            this.value = value;
        }
    }

    public static final String DESTINATION = "D:/selenide";

}
