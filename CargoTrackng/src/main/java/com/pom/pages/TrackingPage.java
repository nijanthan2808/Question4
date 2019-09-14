package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class TrackingPage extends ProjectWrappers {

	String currentStatus;
	public TrackingPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		/*
		 * Thread.sleep(5000);
		 * if (!
		 * verifyTitle("Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */
	}
	
	public TrackingPage getTrackingNumber() throws InterruptedException {
		getTextById( prop.getProperty("Tracking.TrackingNumber"));
		return this;
	}

	public TrackingPage writeTrackingNumber() throws InterruptedException {
		//code to write the created tracking id in Mobile app data sheet.
		return this;
	}
	public TrackingPage enterTrackingNumber(String trackingNumber) throws InterruptedException {
		enter("id", prop.getProperty("Tracking.EnterTrackingNumber"), trackingNumber);
		return this;
	}
	
	public TrackingPage clickTrack() throws InterruptedException {
		click("id", prop.getProperty("Tracking.TrackButton"));
		return this;
	}
	public TrackingPage getTrackingStatus() throws InterruptedException {
		currentStatus = getTextById( prop.getProperty("Tracking.CurrentStatus"));
		
		return this;
	}
	public TrackingPage verifytTrackingStatus() throws InterruptedException {
		
		if(prop.getProperty("Track.StatusFromMobile").equals(currentStatus)) {
			System.out.println("Tracking status has been updated in web and mobile apps. And its been verified");
		}
		return this;
	}
}
