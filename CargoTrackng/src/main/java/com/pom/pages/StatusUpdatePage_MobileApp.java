package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class StatusUpdatePage_MobileApp extends ProjectWrappers {

	public StatusUpdatePage_MobileApp(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		/*
		 * Thread.sleep(5000);
		 * if (!
		 * verifyTitle("Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */
	}

	public StatusUpdatePage_MobileApp enterTrackingNumber(String trackingNumber) throws InterruptedException {
		enter("id", prop.getProperty("Status.EnterTrackingNumber"), trackingNumber);
		return this;
	}
	
	public StatusUpdatePage_MobileApp clickGetStatus() throws InterruptedException {
		click("id", prop.getProperty("Status.GetStatus"));
		return this;
	}
	
	public StatusUpdatePage_MobileApp clickUpdateStatus() throws InterruptedException {
		click("id", prop.getProperty("Status.UpdateStatus"));
		return this;
	}
	
	public StatusUpdatePage_MobileApp getTrackingStatus() throws InterruptedException {
		getTextById( prop.getProperty("Status.TrackingStatus"));
		return this;
	}

}
