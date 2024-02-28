package jdk11to17;

import java.util.HashMap;

public class DemoHasMap {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();

        Person person1 = new Person("John", 30);
        Person person2 = new Person("Alice", 25);

        map.put(person1, "Engineer");
        map.put(person2, "Doctor");

        // Adding another Person object with the same hash code but different name
        Person person3 = new Person("Bob", 40);
        map.put(person3, "Artist");

        // Retrieving values from the map
        System.out.println("Profession of John: " + map.get(person1)); // Should print "Engineer"
        System.out.println("Profession of Alice: " + map.get(person2)); // Should print "Doctor"

        // Trying to retrieve the value of person3
        System.out.println("Profession of Bob: " + map.get(person3)); // Should ideally print "Artist" but may print null

        // Size of the map
        System.out.println("Size of map: " + map.size()); // Should print 3, but may print 2
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding hashCode to return the same value for all Person objects
    @Override
    public int hashCode() {
        return 1; // Returning a constant hash code
    }

    // Overriding equals to compare only the name of Person objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }
}
