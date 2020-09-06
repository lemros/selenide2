package pages;


public class Builder {
    private String serviceName;
    private String url;
    private String name;
    private String findByName;
    private String findByType;
    private String value;

    public Builder(String type){
        switch(type) {
            case "SepaPayment":
                // code block
                break;
            case "Login":
                // code block
                break;
            default:
                // code block
        }

    }

    public Builder(String name, String findByName, String findByType) {
        this.name = name;
        this.findByName = findByName;
        this.findByType = findByType;
    }

    public Builder(String name, String findByName, String findByType, String value) {
        this.name = name;
        this.findByName = findByName;
        this.findByType = findByType;
        this.value = value;
    }

    private Builder(String serviceName, String url) {
        this.serviceName = serviceName;
        this.url = url;
    }

}
