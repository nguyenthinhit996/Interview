# New Features in Java 8: 
## Lambda-Function, 
## StreamAPI, 
## Default Methods
## Optional Class
## Date-Time API

-------

Java 8 introduces several significant features and enhancements, revolutionizing the way developers write code and design applications. Let's explore some of these new features along with examples comparing them to previous versions of Java.

## Lambda Expressions

Lambda expressions provide a concise way to represent anonymous functions, allowing for functional programming constructs in Java. They simplify the syntax and enable more readable code.

**Example:**

Java 8:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach(number -> System.out.println(number));
```
Java 7 and Earlier:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
for (Integer number : numbers) {
    System.out.println(number);
}
```
## Stream API

The Stream API facilitates functional-style operations on streams of elements, providing a more declarative way to manipulate collections compared to traditional iteration.

Java 8:
```java
List<String> strings = Arrays.asList("apple", "banana", "cherry");
long count = strings.stream()
                   .filter(s -> s.startsWith("a"))
                   .count();
System.out.println("Count: " + count);

```
Java 7 and Earlier:

```java
List<String> strings = Arrays.asList("apple", "banana", "cherry");
int count = 0;
for (String s : strings) {
    if (s.startsWith("a")) {
        count++;
    }
}
System.out.println("Count: " + count);

```

## Default Methods

Default methods enable adding new methods to interfaces without breaking existing implementations, promoting code reuse and flexibility.

Java 8:
```java
interface MyInterface {
    default void myMethod() {
        System.out.println("Default method implementation");
    }
}

```

Java 7 and Earlier:
// Prior to Java 8, interfaces cannot have concrete method implementations.
// Implementing this in earlier versions would require modifying all implementing classes.


## Optional Class

The Optional class provides a more elegant and null-safe way to handle potentially absent values, reducing NullPointerExceptions.

Java 8:
```java
Optional<String> maybeName = Optional.ofNullable(getName());
String name = maybeName.orElse("Unknown");
System.out.println("Name: " + name);
```
Java 7 and Earlier:
```java
String name = getName();
if (name == null) {
    name = "Unknown";
}
System.out.println("Name: " + name);

```

## Date-Time API

The new Date-Time API simplifies date and time manipulation, addressing long-standing issues with the legacy Date and Calendar classes.

Java 8
```java
LocalDate today = LocalDate.now();
LocalDate tomorrow = today.plusDays(1);
System.out.println("Tomorrow: " + tomorrow);
```
Java 7 and Earlier:
// Date and Calendar classes were cumbersome to use and prone to errors.
// Handling date operations required intricate code with potential bugs.

