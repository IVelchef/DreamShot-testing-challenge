package com.framersite.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class Base3DFramerSitePage extends BaseWebPage {

    public Base3DFramerSitePage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("3DFramerSiteBaseUrl");
    }
}


