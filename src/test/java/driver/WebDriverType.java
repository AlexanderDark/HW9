package driver;

public enum WebDriverType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    DEFAULT ("chrome");

    String webDriberType;
    WebDriverType (String wDT) {
        this.webDriberType = wDT;
    }

    public String getBrowserName() {
        return webDriberType;
    }

    public static WebDriverType findByName(String name) {
        for (WebDriverType value: values()) {
            if (value.webDriberType.equals(name.replace("'","").toLowerCase())) {
                return value;
            }
        }
        return DEFAULT;
    }

}
