package com.pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.pom.wrappers.ProjectWrappers;
import com.relevantcodes.extentreports.ExtentTest;

public class BokingPage extends ProjectWrappers {

	public BokingPage(RemoteWebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		/*
		 * Thread.sleep(5000);
		 * 
		 * 
		 * if (!
		 * verifyTitle("Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience"
		 * )) { reportStep("This is not the Emirates Home Page", "FAIL"); }
		 */		 
	}



	public BokingPage enterOrigin(String origin) throws InterruptedException {
		enter("id", prop.getProperty("Booking.Origin"), origin);
		return this;
	}

	public BokingPage enterDestination( String destination) throws InterruptedException {
		enter("id", prop.getProperty("Booking.Destination.id"), destination);
		return this;
	}
	
	public BokingPage enterItemDetails( String itemDetails) throws InterruptedException {
		enter("id", prop.getProperty("Booking.ItemDetails.id"), itemDetails);
		return this;
	}
	
	public BokingPage enterFromAddress( String fromAddress) throws InterruptedException {
		enter("id", prop.getProperty("Booking.FromAddress.id"), fromAddress);
		return this;
	}
	
	public BokingPage enterToAddress(String toAddress) throws InterruptedException {
		enter("id", prop.getProperty("Booking.ToAddress.id"), toAddress);
		return this;
	}
	
	public BokingPage enterCharge( String charge) throws InterruptedException {
		enter("id", prop.getProperty("Booking.Charge.id"), charge);
		return this;
	}
	
	public BokingPage enterSenderPhone( String senderPhone) throws InterruptedException {
		enter("id", prop.getProperty("Booking.SenderPhone.id"), senderPhone);
		return this;
	}
	
	public BokingPage enterReceiverPhone( String receiverPhone) throws InterruptedException {
		enter("id", prop.getProperty("Booking.SenderPhone.id"), receiverPhone);
		return this;
	}
	
	public TrackingPage clickBook( ) throws InterruptedException {
		click("id", prop.getProperty("Booking.SenderPhone.id"));
		return new TrackingPage(driver, test);
	}
}
