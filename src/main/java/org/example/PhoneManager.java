package org.example;

import java.util.*;

class PhoneManager {
    private List<Phone> phoneList = new ArrayList<>();
    private Map<Integer, Phone> phoneMap = new HashMap<>();

    // Add phone to list
    public void addPhone(Phone phone) {
        phoneList.add(phone);
        System.out.println("Phone Added: " + phone.getName());
    }

    // Remove phone by ID
    public boolean removePhoneById(int id) {
        boolean removed = phoneList.removeIf(phone -> phone.getId() == id);
        System.out.println(removed ? "Phone removed: id=" + id : "Phone not found: id=" + id);
        return removed;
    }

    // Sort phones by name (using lambda)
    void sortPhonesByName() {
        System.out.println("Sorted by name (using lambda)");
        phoneList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    // Sort phones by cost (using Comparator.comparingDouble - method reference)
    void sortPhonesByCost() {
        System.out.println("Sorted by cost (using Comparator.comparingDouble)");
        phoneList.sort(Comparator.comparingDouble(Phone::getCost));
    }

    // Sort phones by cost descending (using anonymous class)
    void sortPhonesByCostDesc() {
        System.out.println("Sorted by cost descending (using anonymous class)");
        phoneList.sort(new Comparator<Phone>() {
            public int compare(Phone o1, Phone o2) {
                return Double.compare(o2.getCost(), o1.getCost());
            }
        });
    }

    // Sort phones by date of birth (using separate Comparator class)
    void sortdob() {
        System.out.println("Sorted by date of birth (using Comparator class)");
        phoneList.sort(new DobComparator());
    }

    // Inner class for date comparison
    class DobComparator implements Comparator<Phone> {
        public int compare(Phone o1, Phone o2) {
            String[] date1 = o1.getDob().split("-");
            String[] date2 = o2.getDob().split("-");

            int year1 = Integer.parseInt(date1[2]);
            int year2 = Integer.parseInt(date2[2]);
            if (year1 != year2) return Integer.compare(year1, year2);

            int month1 = Integer.parseInt(date1[1]);
            int month2 = Integer.parseInt(date2[1]);
            if (month1 != month2) return Integer.compare(month1, month2);

            int day1 = Integer.parseInt(date1[0]);
            int day2 = Integer.parseInt(date2[0]);
            return Integer.compare(day1, day2);
        }
    }

    // Display all phones
    void displayPhones() {
        phoneList.forEach(System.out::println);
    }

    // Filter phone by ID
    public Phone filterPhoneById(int id) {
        return phoneList.stream()
                .filter(phone -> phone.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Filter phones by cost
    public List<Phone> filterPhonesByCost(double maxCost) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getCost() <= maxCost) {
                result.add(phone);
            }
        }
        return result;
    }

    // Add phone to map
    public void addPhoneMap(Phone phone) {
        phoneMap.put(phone.getId(), phone);
        System.out.println("Phone added to map: " + phone.getName());
    }

    // Remove phone from map
    public void removePhoneMap(int id) {
        Phone removed = phoneMap.remove(id);
        System.out.println(removed != null ? "Phone removed from map: id=" + id : "Phone not found in map: id=" + id);
    }

    // Display all phones from map
    void displayPhonesMap() {
        phoneMap.values().forEach(System.out::println);
    }

    // Sort map phones by name (using lambda)
    void sortMapPhonesByName() {
        System.out.println("Sorted by name (using lambda)");
        phoneMap.values().stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .forEach(System.out::println);
    }

    // Sort map phones by cost (using Comparator.comparingDouble - method reference)
    void sortMapPhonesByCost() {
        System.out.println("Sorted by cost (using Comparator.comparingDouble)");
        phoneMap.values().stream()
                .sorted(Comparator.comparingDouble(Phone::getCost))
                .forEach(System.out::println);
    }

    // Sort map phones by cost descending (using anonymous class)
    void sortMapPhonesByCostDesc() {
        System.out.println("Sorted by cost descending (using anonymous class)");
        phoneMap.values().stream()
                .sorted(new Comparator<Phone>() {
                    public int compare(Phone o1, Phone o2) {
                        return Double.compare(o2.getCost(), o1.getCost());
                    }
                })
                .forEach(System.out::println);
    }

    // Sort map phones by date of birth (using Comparator class)
    void sortMapPhonesByDob() {
        System.out.println("Sorted by date of birth (using Comparator class)");
        phoneMap.values().stream()
                .sorted(new DobComparator())
                .forEach(System.out::println);
    }

    // Filter phone by ID from map
    public Phone filterMapPhoneById(int id) {
        return phoneMap.get(id);
    }

    // Filter map phones by cost
    public List<Phone> filterMapPhonesByCost(double maxCost) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneMap.values()) {
            if (phone.getCost() <= maxCost) {
                result.add(phone);
            }
        }
        return result;
    }
}
