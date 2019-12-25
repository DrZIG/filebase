package common;

public class Setting {
    private String key;

    public Setting(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String get() {
        return Settings.getSettings().getSetting(getKey());
    }
}
