package com.pom.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.pages.BokingPage;
import com.pom.pages.StatusUpdatePage_MobileApp;
import com.pom.wrappers.ProjectWrappers;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class UpdateStatus_MobileApp extends ProjectWrappers {
	{
		System.setProperty("atu.reporter.config", "./resources/atu.properties");
		ATUReports.currentRunDescription = "Test cases for Cargo mobile app";
	}

	@BeforeSuite
	public void setSheetName() {
		dataSheetName = "CargoMobileApp";
	}

	@Test(dataProvider = "fetchData")

	public void updateStatus(String trackingNumber) throws InterruptedException {

		ATUReports.setAuthorInfo(prop.getProperty("Authors"), Utils.getCurrentTime(), "1.0");
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Test case for Cargo mobile app");

		new StatusUpdatePage_MobileApp(driver, test).enterTrackingNumber(trackingNumber).clickGetStatus()
				.clickUpdateStatus().getTrackingStatus();
	}

}
