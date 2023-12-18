package com.saucelab.utils;

import com.saucelab.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class Utils extends TestBase {
    public static long pageLoadTimeOut = 25;
    public static long implicitTimeOut = 15;
    public static String dataProviderFilePath = "src/main/java/com/saucelab/testData/saucelab.xlsx";
    static Workbook workbook;
    static Sheet sheet;


    public Object[][] getData (String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (dataProviderFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            workbook = WorkbookFactory.create (fileInputStream);
        } catch (IOException e2) {
            e2.printStackTrace ();
        }
        sheet = workbook.getSheet (sheetName);
        Object[][] data = new Object[sheet.getLastRowNum ()][sheet.getRow (sheet.getLastRowNum ()).getLastCellNum ()];
        for (int i = 1; i <= sheet.getLastRowNum (); i++) {
            for (int j = 0; j < sheet.getRow (0).getLastCellNum (); j++) {
                data[i-1][j] = sheet.getRow (i).getCell (j).getStringCellValue ();
                System.out.println (data[i-1][j]);
            }
            System.out.println ("----");
        }

        return data;
    }

    public static void takeScreenshot(Method method){
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver ();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(
                System.getProperty("user.dir") + "/src/test/resources/failed_test_screenshots/" +System.currentTimeMillis ()
                        +"-"+method.getName ()+ ".png");

        try {
            FileHandler.copy(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
