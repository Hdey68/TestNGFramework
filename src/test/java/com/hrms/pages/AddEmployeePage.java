package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

    @FindBy(xpath ="//input[@name='firstName']" )
    public WebElement firstNameTextBox;

    @FindBy(id="middleName")
    public WebElement middleNameTextBox;

    @FindBy(id="lastName")
    public WebElement lastNameTextBox;

    @FindBy(id="employeeId")
    public WebElement empIDTextBox;

    @FindBy(xpath="//*[@id=\"photofile\"]")
    public WebElement chooseFile;

    @FindBy(id="chkLogin")
    public WebElement createLoginCheckBox;

    @FindBy(id="user_name")
    public WebElement usernameTextBox;

    @FindBy(id="user_password")
    public WebElement passwordTextBox;

    @FindBy(id="re_password")
    public WebElement confirmPasswordTextBox;

    @FindBy(id="btnSave")
    public WebElement saveButton;


     public AddEmployeePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
