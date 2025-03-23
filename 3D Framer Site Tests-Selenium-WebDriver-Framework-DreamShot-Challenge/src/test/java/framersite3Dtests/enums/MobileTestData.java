package framersite3Dtests.enums;

import org.openqa.selenium.Dimension;

public enum MobileTestData {

    SAMSUNG_A51("Samsung A51", new Dimension(412, 914)),
    IPHONE_13_PRO("iPhone 13 Pro", new Dimension(390, 844));

    private final String deviceName;
    private final Dimension screenDimension;

    MobileTestData(String deviceName, Dimension screenDimension) {
        this.deviceName = deviceName;
        this.screenDimension = screenDimension;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public Dimension getScreenDimension() {
        return screenDimension;
    }
}
