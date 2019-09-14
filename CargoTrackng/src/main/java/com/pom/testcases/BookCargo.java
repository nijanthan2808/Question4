package com.pom.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.pages.BokingPage;
import com.pom.wrappers.ProjectWrappers;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class BookCargo extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for Cargo booking";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "BookCargo";
	}

	@Test(dataProvider = "fetchData")

	public void bookCargo(String origin, String destination, String itemDetails, String fromAddress,
			String toAddress, String charge, String senderPhone, String receiverPhone) throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for Cargo booking");

		new BokingPage(driver, test).enterOrigin(origin).enterDestination(destination).enterItemDetails(itemDetails)
				.enterFromAddress(fromAddress).enterToAddress(toAddress).enterCharge(charge)
				.enterSenderPhone(senderPhone).enterReceiverPhone(receiverPhone).clickBook().getTrackingNumber().writeTrackingNumber();

	}

}
