package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneManager manager = new PhoneManager();

        // Add phones to list
        manager.addPhone(new Phone(101, "Galaxy S21", "Samsung", 799.99, 108, "01-05-2004"));
        manager.addPhone(new Phone(102, "iPhone 13", "Apple", 999.99, 12, "13-04-2004"));
        manager.addPhone(new Phone(103, "Pixel 6", "Google", 599.99, 50, "13-04-2005"));

        System.out.println("\n=== Original List ===");
        manager.displayPhones();

        System.out.println("\n=== Sorted by Cost (Low to High) ===");
        manager.sortPhonesByCost();
        manager.displayPhones();

        System.out.println("\n=== Sorted by Cost (High to Low) ===");
        manager.sortPhonesByCostDesc();
        manager.displayPhones();

        System.out.println("\n=== Sorted by Name ===");
        manager.sortPhonesByName();
        manager.displayPhones();

        System.out.println("\n=== Sorted by Date of Birth ===");
        manager.sortdob();
        manager.displayPhones();

        System.out.println("\n=== Filter Phone by ID ===");
        Phone foundPhone = manager.filterPhoneById(102);
        System.out.println(foundPhone != null ? foundPhone : "Phone not found");

        System.out.println("\n=== Filter Phones by Cost (under $800) ===");
        List<Phone> affordablePhones = manager.filterPhonesByCost(800);
        affordablePhones.forEach(System.out::println);

        // Add phones to map
        System.out.println("\n=== Adding Phones to Map ===");
        manager.addPhoneMap(new Phone(104, "OnePlus 9", "OnePlus", 729.99, 48, "23-03-2006"));
        manager.addPhoneMap(new Phone(105, "Xperia 5", "Sony", 899.99, 12, "11-11-2003"));
        manager.addPhoneMap(new Phone(106, "Moto G Power", "Motorola", 249.99, 16, "05-06-2002"));
        manager.addPhoneMap(new Phone(107, "Nokia 8.3", "Nokia", 699.99, 64, "15-08-2001"));

        System.out.println("\n=== Display Phones from Map ===");
        manager.displayPhonesMap();

        System.out.println("\n=== Map: Sorted by Name ===");
        manager.sortMapPhonesByName();

        System.out.println("\n=== Map: Sorted by Cost (Low to High) ===");
        manager.sortMapPhonesByCost();

        System.out.println("\n=== Map: Sorted by Cost (High to Low) ===");
        manager.sortMapPhonesByCostDesc();

        System.out.println("\n=== Map: Sorted by Date of Birth ===");
        manager.sortMapPhonesByDob();

        System.out.println("\n=== Map: Filter Phone by ID ===");
        Phone mapPhone = manager.filterMapPhoneById(105);
        System.out.println(mapPhone != null ? mapPhone : "Phone not found");

        System.out.println("\n=== Map: Filter Phones by Cost (under $750) ===");
        List<Phone> mapAffordablePhones = manager.filterMapPhonesByCost(750);
        mapAffordablePhones.forEach(System.out::println);

        System.out.println("\n=== Map: Remove Phone by ID ===");
        manager.removePhoneMap(106);

        System.out.println("\n=== Display Phones from Map After Removal ===");
        manager.displayPhonesMap();
    }
}