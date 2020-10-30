package com.emphasis.main;
import com.emphasis.controller.AddressBookController;
import java.util.Scanner;
/*
 * @author:alekhya
 * @created date:24th oct 2020
 * @functionality:Simple Address Book Main File
 */
public class AddressBook {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        AddressBookController addressBookController = new AddressBookController();
        while (true) {
        System.out.println("Select an option!");
        System.out.println("1. Create New Address Book ");
        System.out.println("2. Open Existing Address Book ");
        System.out.println("3. Add a person");
        System.out.println("4. Edit Detail Of A person");
        System.out.println("5. Delete A Person ");
        System.out.println("6. Sort A Person By LastName ");
        System.out.println("7. Sort A Person By Zipcode");
        System.out.println("8. Print All Persons ");
        System.out.println("9. Print A person Details");
        //System.out.println("10. Save the Address Book");
        //System.out.println("11. Close Address Book");
        System.out.println("12. Quit the Address Book program");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    //code
                    System.out.println("Create new Address book");
                    addressBookController.createNewAddressBook();
                    break;
                case 2:
                    //code
                    System.out.println("open Already existing address book");
                    addressBookController.openExistingAddressBook();
                    break;
                case 3:
                    System.out.println("Add the person details");
                    addressBookController.addPerson();
                    break;
                case 4:
                    //code
                    System.out.println("\n Enter Person you want to Edit th details");
                    addressBookController.editDetailsOfPerson();
                    break;
                case 5:
                    //code
                    System.out.println("Enter first name of a person u want to delete");
                    addressBookController.deletePerson();
                    break;
                case 6:
                    //code
                    System.out.println("To sort persons details by their last name");
                    addressBookController.sortPersonByLastName();

                    break;
                case 7:
                    //code
                    System.out.println("To sort person details by their zip code");
                    addressBookController.sortPersonByZipCode();
                    break;
                case 8:
                    //code
                    System.out.println("Print the all person Details");
                    addressBookController.printAllPersons();
                    break;
                case 9:
                    //code
                    System.out.println("Enter the person you want to print the details");
                    addressBookController.printPersonDetails();
                    break;
                /*case 10:
                    //code
                    System.out.println("save Address book");
                    break;
                case 11:
                    //code
                    System.out.println("close address book");

                    break;*/
                case 12:
                    //code
                    System.out.println("Quit address book");
                    return;
                default:
                    System.out.print("Please choose option a valid menu number");
            }
        }
    }
}
