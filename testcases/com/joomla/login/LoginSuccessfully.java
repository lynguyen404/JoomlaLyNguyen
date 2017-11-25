package com.joomla.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.Articles;
import pages.Content;
import pages.EditContent;
import pages.HomePage;
import pages.LoginPage;
import pages.PageFactory;

public class LoginSuccessfully extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) throws Exception {

		String username;
		String password;
		username = "automationfc";
		password = "automationfc";
		titlename = "title" + randomEmail();
		valueofdropdown = "- Manual Testing";
		valueoftextarea = "Testing Automation";
		savedarticlessuccessfully = "Article saved.";
		edittitlename = "Edittitle" + randomEmail();
		editvalueofdropdown = "- Automation Testing";
		editvalueoftextarea = "Edit Testing Automation";
		savedarticlessuccessfully = "Article saved.";
		valueofstatusdropdown="Unpublished";
		publicsuccessfully="1 article published.";
		driver = openBrowser(browser, url);
		loginPage = PageFactory.getLoginPage(driver);
		loginPage.typeToUsername(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLogin();
	}

	//@Test
	public void TC_01_CreateArticlesSuccessfully() {
		articles = homePage.clickOnMenuArticles();
		content = articles.clickToNewButton();
		content.typeToTitle(titlename);
		content.isSelectCatagory(valueofdropdown);
		content.moveToJform();
		content.typeToTextArea(valueoftextarea);
		content.moveToDefault(driver);
		homePage = content.clickToSaveAndClose();
		verifyTrue(homePage.isDisplayArticlesSaved(savedarticlessuccessfully));
	}
	//@Test
	public void TC_02_EditArticlesSuccessfully(){
		content = articles.clickToNewButton();
		content.typeToTitle(titlename);
		content.isSelectCatagory(valueofdropdown);
		content.moveToJform();
		content.typeToTextArea(valueoftextarea);
		content.moveToDefault(driver);
		homePage = content.clickToSaveAndClose();
		articles.isCheckedCheckbox();
		editcontent=articles.clickToEditButton();
		editcontent.typeToTitle(edittitlename);
		editcontent.isSelectCatagory(editvalueofdropdown);
		editcontent.moveToJform();
		editcontent.typeToTextArea(editvalueoftextarea);
		editcontent.moveToDefault(driver);
		homePage = editcontent.clickToSaveAndClose();
		verifyTrue(homePage.isDisplayArticlesSaved(savedarticlessuccessfully));
	}
	
	@Test
	public void TC_03_PublicArticlesSuccessfully() {
		articles = homePage.clickOnMenuArticles();
		content = articles.clickToNewButton();
		content.typeToTitle(titlename);
		content.isSelectCatagory(valueofdropdown);
		content.isSelectStatus(valueofstatusdropdown);
		content.moveToJform();
		content.typeToTextArea(valueoftextarea);
		content.moveToDefault(driver);
		homePage = content.clickToSaveAndClose();
		verifyTrue(homePage.isDisplayArticlesSaved(savedarticlessuccessfully));
		articles.isCheckedCheckbox();
		articles.isPublicArticles();
		articles.isDisplayPubicArticles(publicsuccessfully);
	}
	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	private LoginPage loginPage;
	private HomePage homePage;
	private Articles articles;
	private Content content;
	private EditContent editcontent;
	private String titlename, valueofdropdown, valueoftextarea, savedarticlessuccessfully;
	private String edittitlename, editvalueofdropdown, editvalueoftextarea;
	private String valueofstatusdropdown,publicsuccessfully;
	
	
}
