package com.emphasis.controller;

import com.emphasis.model.Person;
import com.emphasis.service.AddressBookServices;
import com.emphasis.service.PersonServices;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
/*
 * @author:alekhya
 * @created date:24th oct 2020
 * @functionality:AddressBookController calls person services and Address Book services
 *                and then called by main class Address Book
 */
public class AddressBookController {
    //call the service objects and perform the function
    FileWriter csvWriter;
    Scanner csvReader;
    String inputPath;
    Scanner scanner=new Scanner(System.in);
    PersonServices personServices=new PersonServices();
    AddressBookServices addressBookServices=new AddressBookServices();
    public void createNewAddressBook(){

        inputPath=addressBookServices.createNewAddressBook();

    }
    public void openExistingAddressBook(){

        inputPath=addressBookServices.openExistingAddressBook();

    }
    public void addPerson(){
        /*
         * functionality:In this method we get the data from PersonServices and place
         *               them in csv file
         */
        Person personObjects=personServices.addPerson();
        try {
            csvWriter= new FileWriter(inputPath,true);
            //append String Represents of Array to file
            csvWriter.append(personObjects.toString());
            csvWriter.append("\n");
            csvWriter.flush();//clear the stream
            csvWriter.close();
            System.out.println("Successfully added a new person details to address book");
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }
    public void editDetailsOfPerson(){
        /*
         * functionality:In this method we get the data from PersonServices and place
         *               them in one file then do operations on that file then again
         *               write to Csv File
         *               this method calls the Write to Csv File method
         */
        List<Person> personList=new ArrayList<>();
        personList=personServices.readTheDataFromCsv(inputPath);
        System.out.println("Enter the Phone number of a person which you want to Edit ");
        String PhoneNumber=scanner.nextLine();
        for (Person person: personList){
            if (person.getPhoneNumber() .equalsIgnoreCase(PhoneNumber)){
                Person p=personServices.editDetailsOfPerson();
                int index= personList.indexOf(person);
                personList.set(index,p);
                break;
            }
        }
        WriteToCsvFile(personList);
        System.out.println("Successfully edited one person details in address book");
    }
    public void deletePerson(){
        /*
         * functionality:In this method we get the data from PersonServices and place
         *               them in one file then do operations on that file then again
         *               write to Csv File
         *               this method calls the Write to Csv File method
         */
        List<Person> personList=new ArrayList<>();
        personList=personServices.readTheDataFromCsv(inputPath);
        System.out.println("Enter the Phone number of a person which you want to delete ");
        String PhoneNumber=scanner.nextLine();
        for (Person person: personList){
            if (person.getPhoneNumber() .equalsIgnoreCase(PhoneNumber)){
                int index= personList.indexOf(person);
                personList.remove(index);
                break;
            }
        }
        WriteToCsvFile(personList);
        System.out.println("Successfully deleted one person details from address book");
    }
    public void sortPersonByLastName(){
        /*
         * functionality:In this method we get the data from PersonServices and place
         *               them in one file then do operations on that file then again
         *               write to Csv File
         *               this method calls the Write to Csv File method
         *               this method calls the print all persons method
         */
        List<Person> personList=new ArrayList<>();
        personList=personServices.readTheDataFromCsv(inputPath);
        Collections.sort(personList,new SortbyLastName());
        WriteToCsvFile(personList);
        printAllPersons();
        System.out.println("Successfully sorted address book by person's last name");
    }
    public void sortPersonByZipCode(){
        /*
         * functionality:In this method we get the data from PersonServices and place
         *               them in one file then do operations on that file then again
         *               write to Csv File
         *               this method calls the Write to Csv File method
         *               this method calls the print all persons method
         */
        List<Person> personList=new ArrayList<>();
        personList=personServices.readTheDataFromCsv(inputPath);
        Collections.sort(personList,new SortbyZipCode());
        WriteToCsvFile(personList);
        printAllPersons();
        System.out.println("Successfully sorted address book by person's Zip code");
    }
    public void printAllPersons(){
        /*
         * functionality:In this method we get all details of a person from
         *               present Address Book
         */
        try {
            Scanner csvReader = new Scanner(new FileReader(inputPath));
            csvReader.useDelimiter("\n");
            while (csvReader.hasNext())
            {
                System.out.println(csvReader.next());
            }
            csvReader.close();
            System.out.println("Successfully read file");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void printPersonDetails(){
        /*
         * functionality:In this method we get the data from PersonServices class
         *               readtheDataFromCsv method and place them in one file from
         *               that file we can extract the details of a single person
         *               from Address Book
         */
        List<Person> personList=new ArrayList<>();
        personList=personServices.readTheDataFromCsv(inputPath);
        //code
        System.out.println("Enter the Phone number of a person which you want to se ");
        String PhoneNumber=scanner.nextLine();
        for (Person person: personList){
            if (person.getPhoneNumber() .equalsIgnoreCase(PhoneNumber)){
                System.out.println(person.toString());
                break;
            }
        }
    }
    public void  WriteToCsvFile(List<Person> personList){
        /*
         * functionality:In this method we get the data after doing operations
         *               then place that updated data into Csv file
         * @para        -List<Person> personList
         */
        try {
            csvWriter= new FileWriter(inputPath);
            for (Person person: personList){
                csvWriter.append(person.toString());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

        }catch (Exception exception){
            System.out.println(exception);
        }
    }
}
class SortbyLastName implements Comparator<Person> {
    /*
     * functionality:In this class we implement the comparator
     *               which is inbuild in util package
     */
    public int compare(Person csvLine1,Person csvLine2) {
        /*
         * functionality:In this method we get the data after doing operations
         *               then place that updated data into Csv file
         * @para        -csvline1
         * @para        -csvline2
         * @return      -returns comparison of csv line 1 lastname and csv line 2 lastname
         */
        return csvLine1.getLastName().compareToIgnoreCase(csvLine2.getLastName());
    }
}
class SortbyZipCode implements Comparator<Person> {
    /*
     * functionality:In this class we implement the comparator
     *               which is inbuild in util package
     */
    public int compare(Person a,Person b) {
        /*
         * functionality:In this method we get the data after doing operations
         *               then place that updated data into Csv file
         * @para        -csvline1
         * @para        -csvline2
         * @return      -returns comparison of csv line 1 zipcode and csv line 2 zipcode
         */
        return a.getZip().compareToIgnoreCase(b.getZip());
    }
}





