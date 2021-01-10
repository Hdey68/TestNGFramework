package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods{

    @FindBy(id="firstName")
    WebElement firstNameTextBox;

    @FindBy(id="middleName")
    WebElement middleNameTextbox;

    @FindBy(id="lastName")
    WebElement lastNameTextbox;

    @FindBy(id="employeeId")
    WebElement empIDTextbox;

    @FindBy(id="btnSave")
    WebElement saveButton;

    @FindBy(id="chkLogin")
    WebElement createLoginCheckbox;

    AddEmployeePage (){
        PageFactory.initElements( CommonMethods.driver,this);
    }
}
