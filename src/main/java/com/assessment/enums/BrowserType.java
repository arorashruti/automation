package com.assessment.enums;

public enum BrowserType {

    FIREFOX("FIREFOX"),
    CHROME("CHROME"),
    EDGE("EDGE"),
    SAFARI("SAFARI");

    private final String browserType;

    BrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getbrowserType() {
        return browserType;
    }

}
