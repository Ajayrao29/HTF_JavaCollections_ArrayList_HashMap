package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        PhoneManager manager = new PhoneManager();
        Scanner sc = new Scanner(System.in);

        // Preload Data
        manager.addPhone(new Phone(101, "Galaxy S21", "Samsung", 799.99, 108, "01-05-2004"));
        manager.addPhone(new Phone(102, "iPhone 13", "Apple", 999.99, 12, "13-04-2004"));
        manager.addPhone(new Phone(103, "Pixel 6", "Google", 599.99, 50, "13-04-2005"));

        manager.addPhoneMap(new Phone(104, "OnePlus 9", "OnePlus", 729.99, 48, "23-03-2006"));
        manager.addPhoneMap(new Phone(105, "Xperia 5", "Sony", 899.99, 12, "11-11-2003"));
        manager.addPhoneMap(new Phone(106, "Moto G Power", "Motorola", 249.99, 16, "05-06-2002"));
        manager.addPhoneMap(new Phone(107, "Nokia 8.3", "Nokia", 699.99, 64, "15-08-2001"));

        int choice;

        do {
            System.out.println("\n---------- MENU --------");
            System.out.println("1. Display Phones (List)");
            System.out.println("2. Sort by Cost Asc");
            System.out.println("3. Sort by Cost Desc");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by DOB");
            System.out.println("6. Filter by ID (List)");
            System.out.println("7. Filter by Cost (List)");
            System.out.println("8. Display Phones (Map)");
            System.out.println("9. Sort Map by Name");
            System.out.println("10. Sort Map by Cost Asc");
            System.out.println("11. Sort Map by Cost Desc");
            System.out.println("12. Sort Map by DOB");
            System.out.println("13. Filter by ID (Map)");
            System.out.println("14. Filter by Cost (Map)");
            System.out.println("15. Remove Phone from Map");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.displayPhones();
                    break;

                case 2:
                    manager.sortPhonesByCost();
                    manager.displayPhones();
                    break;

                case 3:
                    manager.sortPhonesByCostDesc();
                    manager.displayPhones();
                    break;

                case 4:
                    manager.sortPhonesByName();
                    manager.displayPhones();
                    break;

                case 5:
                    manager.sortdob();
                    manager.displayPhones();
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Phone phone = manager.filterPhoneById(id);
                    System.out.println(phone != null ? phone : "Phone not found");
                    break;

                case 7:
                    System.out.print("Enter Max Cost: ");
                    double cost = sc.nextDouble();
                    manager.filterPhonesByCost(cost)
                            .forEach(System.out::println);
                    break;

                case 8:
                    manager.displayPhonesMap();
                    break;

                case 9:
                    manager.sortMapPhonesByName();
                    break;

                case 10:
                    manager.sortMapPhonesByCost();
                    break;

                case 11:
                    manager.sortMapPhonesByCostDesc();
                    break;

                case 12:
                    manager.sortMapPhonesByDob();
                    break;

                case 13:
                    System.out.print("Enter ID: ");
                    int mapId = sc.nextInt();
                    Phone mapPhone = manager.filterMapPhoneById(mapId);
                    System.out.println(mapPhone != null ? mapPhone : "Phone not found");
                    break;

                case 14:
                    System.out.print("Enter Max Cost: ");
                    double mapCost = sc.nextDouble();
                    manager.filterMapPhonesByCost(mapCost)
                            .forEach(System.out::println);
                    break;

                case 15:
                    System.out.print("Enter ID to Remove: ");
                    int removeId = sc.nextInt();
                    manager.removePhoneMap(removeId);
                    break;

                case 0:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
