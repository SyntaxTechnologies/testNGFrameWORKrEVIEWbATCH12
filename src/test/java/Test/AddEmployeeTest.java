package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeSearchPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class AddEmployeeTest extends CommonMethods {
//    read the configuration file for username and password
//    and add an employee
    @Test
    public void addEmployee(){

        login.LoginMethod(ConfigReader.getPropertyValue("username"),
                ConfigReader.getPropertyValue("password"));

        click(dash.pimOption);
        click(dash.addEmployeeButton);

      sendText(addEmployeePage.firstNameField,"teyfur");
      sendText(addEmployeePage.middleNameField,"voich");
      sendText(addEmployeePage.lastNameField,"ddrru");

//get the employee id
        String empID = addEmployeePage.empIDLocator.getAttribute("value");
        click(addEmployeePage.saveButton);

        System.out.println(empID);

        click(dash.pimOption);
        click(dash.employeeListOption);

        sendText(employeeSearchPage.idField,empID);
        click(employeeSearchPage.searchButton);

        List<WebElement> rowData = employeeSearchPage.rowData;
        for(WebElement data : rowData){
           String ActualId=data.getText();
            Assert.assertEquals(empID,ActualId);
        }
    }

    @Test
    public void addMultipleEmployee() {
//read the employee data from excel file
//assert that u have succesfully added the employee

    }


}
