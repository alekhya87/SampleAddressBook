package com.emphasis.service;

import com.emphasis.model.Person;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * @author:alekhya
 * @created date:24th oct 2020
 * @functionality:In Person Services we have to do the operations on address book
 */
public class PersonServices {

    Scanner scanner=new Scanner(System.in);
    public Person addPerson(){
        /*
         * functionality:this method contain the parameters of a person we want to enter.
         *              this was called by add person method in the Address Book Controller
         * @return      -personObjects
         */
        Person personObjects=new Person();
        System.out.println("\n enter Person First name");
        personObjects.setFirstName(scanner.nextLine());
        System.out.println("\n Enter Person Last name");
        personObjects.setLastName(scanner.nextLine());
        System.out.println("\n Enter Person Address");
        personObjects.setAddress(scanner.nextLine());
        System.out.println("\n Enter Person City name");
        personObjects.setCity(scanner.nextLine());
        System.out.println("\n Enter Person State name");
        personObjects.setState(scanner.nextLine());
        System.out.println("\n Enter Person Zip code");
        personObjects.setZip(scanner.nextLine());
        System.out.println("\n Enter Person Phone Number");
        personObjects.setPhoneNumber(scanner.nextLine());
        return personObjects;
    }
    public Person editDetailsOfPerson(){
        /*
         * functionality:In this method we can edit parameters of a person we want to by giving
         *               Phone Number.this was called by add person method in the Address
         *               Book Controller
         * @returns     -personObjects
         */
        Person personObjects=new Person();
        System.out.println("\n edit Person First name");
        personObjects.setFirstName(scanner.nextLine());
        System.out.println("\n Edit Person Last name");
        personObjects.setLastName(scanner.nextLine());
        System.out.println("\n Edit Person Address");
        personObjects.setAddress(scanner.nextLine());
        System.out.println("\n Edit Person City name");
        personObjects.setCity(scanner.nextLine());
        System.out.println("\n Edit Person State name");
        personObjects.setState(scanner.nextLine());
        System.out.println("\n Edit Person Zip code");
        personObjects.setZip(scanner.nextLine());
        System.out.println("\n Edit Person Phone Number");
        personObjects.setPhoneNumber(scanner.nextLine());
        return personObjects;
    }

    public List<Person> readTheDataFromCsv(String inputPath){
        /*
         * functionality:In this method we Read the Data From The csv File and Then Perform
         *               Operations On that .this was called by Edit person method , delete
         *               Person method , sort person details By Last Name method ,sort
         *               person details By Zip Code method and Print A single Person Details
         *               method in the Address Book Controller
         * @para        - inputPath Path of the csv file we want
         * @return      - personList
         */
        List<Person> personList= new ArrayList<>();
        try {
            Scanner csvReader = new Scanner(new FileReader(inputPath));
            csvReader.useDelimiter("\n");//go to next line
            while (csvReader.hasNext())
            {
                String row=csvReader.next();
                personList.add(new Person(row.split(",")));
            }
            csvReader.close();
        }catch (Exception exception){
            System.out.println(exception);
        }
        return personList;
    }
}
