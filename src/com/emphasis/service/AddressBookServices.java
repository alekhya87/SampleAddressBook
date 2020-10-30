package com.emphasis.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
/*
 * @author:alekhya
 * @created date:24th oct 2020
 * @functionality:Address Book services
 */
public class AddressBookServices {
    Scanner scanner=new Scanner(System.in);
    FileWriter csvWriter=null;
    Scanner csvReader=null;
    String inputPath;
    public String createNewAddressBook(){
        /*
         * functionality:this method contain how to create a new Address Book
         * In this we have to give the path where we want to create the csv file
         */
        try {
            System.out.println("give the file path where you want create");
            inputPath=scanner.nextLine();
            csvWriter= new FileWriter(inputPath);
            csvWriter.flush();
            csvWriter.close();
            System.out.println("Successfully created new address book");
        }
        catch (Exception exception){
            System.out.println(exception);
        }
        return inputPath;
    }
    public String openExistingAddressBook(){
        /*
         * functionality:this method contain how to open existing Address Book
         * In this we have to give the path of the csv file which we want to open
         */
        try {
            System.out.println("give the CSV file path you want to open");
            inputPath=scanner.nextLine();
            Scanner csvReader = new Scanner(new FileReader(inputPath));
            csvReader.useDelimiter("\n");
            while (csvReader.hasNext())
            {
                System.out.println(csvReader.next());
            }
            csvReader.close();
            System.out.println("Successfully opened the file");

        }catch (Exception e){
            System.out.println(e);
        }
        return inputPath;
    }
}
