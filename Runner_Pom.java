package com.runnerpom.demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.baseclass.maven.Baseclass_Demo;
import com.pom.demo.Booked_iti;
import com.pom.demo.Bookin_Confimation;
import com.pom.demo.Booking_Details;
import com.pom.demo.Login_Adactin;
import com.pom.demo.Search_Hotel;
import com.pom.demo.Select_Hotel;

public class Runner_Pom extends Baseclass_Demo {

	public static WebDriver driver = browserlaunch("Chrome");
	public static Login_Adactin log = new Login_Adactin(driver);
	public static Search_Hotel search = new Search_Hotel(driver);
	public static Select_Hotel select = new Select_Hotel(driver);
	public static Booking_Details book = new Booking_Details(driver);
	public static Bookin_Confimation confirm = new Bookin_Confimation(driver);
	public static Booked_iti iti = new Booked_iti(driver);

	public static void main(String[] args) throws IOException {

		url("https://adactinhotelapp.com/");

		manage("maximize");

		sendkeys(log.getUsername(), "Vimalesh123");
		sendkeys(log.getPassword(), "Vimalesh243@T");
		screenshot("Login page");
		click(log.getLogin());
		dropdown_Index(search.getLocation(), 1);
		dropdown_Index(search.getHotels(), 2);
		dropdown_Index(search.getRoomtypes(), 3);
		dropdown_Index(search.getNo_Ofroom(), 1);
		clear(search.getCheckindate());
		sendkeys(search.getCheckindate(), "28/11/2022");
		clear(search.getCheckoutdate());
		sendkeys(search.getCheckoutdate(), "30/11/2022");
		dropdown_Index(search.getAdultroom(), 2);
		dropdown_Index(search.getChildroom(), 1);
		screenshot("Search Page");
		click(search.getSubmit());
		click(select.getRadio());
		click(select.getCont());
		sendkeys(book.getFirstname(), "Vimalesh");
		sendkeys(book.getLastname(), "T");
		sendkeys(book.getAddress(), "Chennai");
		sendkeys(book.getCardno(), "0123456789987654");
		dropdown_Index(book.getCardtype(), 2);
		dropdown_Index(book.getExpmonth(), 4);
		dropdown_Index(book.getExpyear(), 6);
		sendkeys(book.getCvvno(), "222");
		screenshot("Booking details");
		click(book.getBooknow());
		click(confirm.getIti());
		click(iti.getCheckbox());
		click(iti.getCancel());
		popup("accept");
		click(iti.getLogout());

		screenshot("Logout page");

	}

}
