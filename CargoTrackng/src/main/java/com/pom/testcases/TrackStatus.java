package com.pom.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.pages.BokingPage;
import com.pom.pages.StatusUpdatePage_MobileApp;
import com.pom.pages.TrackingPage;
import com.pom.wrappers.ProjectWrappers;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class TrackStatus extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for Cargo status racking";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "Cargo";
	}

	@Test(dataProvider = "fetchData")

	public void trackStatus(String trackingNumber) throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for Cargo Status tracking in web application");

		new TrackingPage(driver, test).enterTrackingNumber(trackingNumber).clickTrack().getTrackingStatus().verifytTrackingStatus();
	}

}
