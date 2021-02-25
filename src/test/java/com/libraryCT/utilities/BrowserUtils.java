package com.libraryCT.utilities;

import org.junit.Assert;

public class BrowserUtils {
    /*
    Method to assert title
     */

    public static void titleVerification(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        //return actualTitle.equals(expectedTitle);
    }




    //create method name: wait
    //converting milliseconds to seconds
    //handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

}
