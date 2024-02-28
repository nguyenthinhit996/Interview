package jdk18to21;

import javax.xml.namespace.QName;

public class PatternMatchingInstanceOfRecord {
    public static void main(String[] args) {

        record Person(String name, Integer age) {
            static String hihi = "hihi";
            private String display() {
                return "Display calling ...";
            }
        }

        Person someone = new Person("John", 12);
        if (someone instanceof Person(String name, Integer age)) {
            System.out.println(someone.display());
            System.out.println(someone.hihi);

            System.out.println(name);
            System.out.println(age);
        }

        //normally we check instead of first then we get value
        Person someone2 = new Person("John", 12);
        if (someone2 instanceof Person) {
            System.out.println(someone2.age);
            System.out.println(someone2.name);
        }
    }
}
