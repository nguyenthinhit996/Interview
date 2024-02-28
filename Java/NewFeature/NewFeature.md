# Table of Contents

1. [Introduction](#Overview)
2. [Java 8](#Java-8)
3. [Java 9,10,11](#Java-9,-10,-and-11)
4. [Java 12 to 17](#Java-12-to-17)
5. [Java 18 to 21](#Java-18-to-21)

---

# Overview
```text
Java 8  
  Lambda-Function  
  StreamAPI  
  Default Methods  
  Optional Class  
  Date-Time API  

Java 9, 10, and 11
  Module System
  JShell (Interactive Java REPL)
  Local Variable Type Inference
  Local Variable Syntax for Lambda Parameters

Java 12 to 17
  Switch Expressions
  Text Blocks
  Records
  Sealed Classes and Interfaces
  Pattern Matching for instanceof
  Strong Encapsulation of JDK Internals by Default

18 to 21
  Simple Web Server
  Virtual Threads
  Record Patterns
  Scoped Values
  Unnamed Variables

Deprecation and removal
  Deprecate Thread.stop for removal  
  Remove Java EE  
  Remove the javah tool  

```

-----
# Java 8
#### Lambda-Function  
#### StreamAPI  
#### Default Methods  
#### Optional Class  
#### Date-Time API
   

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

# Java 9, 10, and 11
#### Module System  
#### JShell (Interactive Java REPL)  
#### Local Variable Type Inference  
#### Local Variable Syntax for Lambda Parameters

-------

## Java 9

### Module System (Project Jigsaw)

Java 9 introduces a modular system to the platform, known as Project Jigsaw. It allows developers to create modular applications, improving encapsulation and maintainability.

#### Example (Java 9):

```java
// Module declaration (module-info.java)
module com.example.module {
    requires java.base;
    exports com.example.package;
}
```
Example (Java 8 and Former): // No module system in Java 8 and former

### JShell (Interactive Java REPL)

JShell is an interactive Read-Eval-Print Loop (REPL) tool introduced in Java 9, allowing developers to execute Java code snippets and experiment with APIs without needing to create a full-fledged Java program.

```java
// Using JShell (Java 9)
jshell> int sum = 1 + 2;
sum ==> 3
```
// No JShell in Java 8 and former

## Java 10
### Local Variable Type Inference
Java 10 introduces local variable type inferen10ce, allowing developers to declare local variables with var, inferring the type from the initialization expression. This reduces verbosity and improves code readability.

```java
// Using var for local variable type inference (Java 10)
var list = new ArrayList<String>();
list.add("Java");

// Without var (Java 8 and former)
List<String> list = new ArrayList<>();
list.add("Java");

```
## Java 11
### Local Variable Syntax for Lambda Parameters
Java 11 allows the use of var in lambda expressions to declare the types of lambda parameters. This enhances readability and reduces verbosity.


```java
// Using var in lambda parameters (Java 11)
BiFunction<Integer, Integer, Integer> add = (var x, var y) -> x + y;

// Without var (Java 8 and former)
BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
```

### HTTP Client (Standard)

Java 11 introduces a new standard HTTP client API that supports HTTP/1.1, HTTP/2, and WebSocket, offering a more modern and flexible alternative to HttpURLConnection.

```java 
// Using the new HTTP client (Java 11)
HttpClient httpClient = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.example.com"))
        .build();
httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println)
        .join();

```
Example (Java 8 and Former):
```java
// Using HttpURLConnection (Java 8 and former)
URL url = new URL("https://api.example.com");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
StringBuilder response = new StringBuilder();
while ((line = reader.readLine()) != null) {
    response.append(line);
}
reader.close();
System.out.println(response.toString());

```

# Java 12 to 17

Java 12 to 17 bring several enhancements and new features to the language and platform, further improving developer productivity and performance. Let's explore some of the key features of each version and compare them with previous versions.

## Java 12

### Switch Expressions (Enhanced)

Java 12 enhances switch expressions introduced in Java 12, allowing them to be used as statements. This improves code readability and reduces verbosity.

#### Example (Java 12):

```java
// Enhanced switch expressions (Java 12)
int dayOfWeek = 3;
String dayType = switch (dayOfWeek) {
    case 1, 2, 3, 4, 5 -> "Weekday";
    case 6, 7 -> "Weekend";
    default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
};
```
Example (Java 11 and Former):
```java
// Traditional switch statement (Java 11 and former)
int dayOfWeek = 3;
String dayType;
switch (dayOfWeek) {
    case 1, 2, 3, 4, 5:
        dayType = "Weekday";
        break;
    case 6, 7:
        dayType = "Weekend";
        break;
    default:
        throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
}

```

## Java 13

### Text Blocks

Java 13 introduces text blocks, a new language feature that simplifies the writing of multiline strings, enhancing code readability.

#### Example (Java 13):
```java 
// Using text blocks (Java 13)
String html = """
              <html>
                  <body>
                      <p>Hello, Java 13!</p>
                  </body>
              </html>
              """;
```
Example (Java 11 and Former):

```java
// Using traditional string concatenation (Java 11 and former)
String html = "<html>\n" +
              "    <body>\n" +
              "        <p>Hello, Java 11!</p>\n" +
              "    </body>\n" +
              "</html>\n";

```

## Java 14


### Records

Java 14 introduces records, a new kind of type declaration to model data more succinctly. Records automatically generate accessor methods, equals(), hashCode(), and toString().

#### Example (Java 14):

```java 
// Using records (Java 14)
record Point(int x, int y) {}

// Using traditional class (Java 11 and former)
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Accessor methods, equals(), hashCode(), and toString() implementations
}

```

## Java 15

### Sealed Classes and Interfaces

Java 15 introduces sealed classes and interfaces, enabling developers to restrict which other classes or interfaces may extend or implement them.
```java

// Using sealed classes and interfaces (Java 15)
sealed interface Shape permits Circle, Rectangle, Triangle {}
// Example (Java 11 and Former):
// No equivalent feature in Java 11 and former

```

## Java 16

### Pattern Matching for instanceof

Java 16 enhances pattern matching by extending it to the instanceof operator, allowing for more concise and readable code.

#### Example (Java 16):
```java
// Pattern matching for instanceof (Java 16)
if (obj instanceof String s) {
    System.out.println(s.length());
} else {
    System.out.println("Not a string");
}

```
Example (Java 11 and Former):

```java
// Traditional instanceof check and casting (Java 11 and former)
if (obj instanceof String) {
String s = (String) obj;
    System.out.println(s.length());
        } else {
        System.out.println("Not a string");
}
```
## Java 17

### Strong Encapsulation of JDK Internals by Default
Java 17 strengthens encapsulation of JDK internals by default, making internal APIs inaccessible unless explicitly opened.  
Recognizing whether an API is internal or not  
start with sun.*, com.sun.*, jdk.internal.*, com.oracle.*, etc.  
Documentation, Deprecated APIs:...
```java 

import sun.misc.BASE64Encoder; // This is an internal API

public class Main {
    public static void main(String[] args) {
        // Attempting to use an internal API
        String encoded = encodeBase64("Hello, world!");
        System.out.println("Encoded: " + encoded);
    }

    // Method using internal API to encode a string to base64
    // This method won't compile in JDK 17 due to strong encapsulation
    private static String encodeBase64(String input) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(input.getBytes());
    }
}

```


## Java 18 to 21

This document highlights the new features introduced in Java versions 18 through 21, providing examples to compare these features with the functionality available in Java 17 and earlier.

## Java 18 (Released March 2022)

### 1. Simple Web Server (JEP 408)
- **Description**: A command-line tool and API for starting a minimal web server that serves static files.
- **Comparison**: Previously, setting up a simple HTTP server required external libraries or boilerplate code.
- **Java 18 Example**:
  shell
  java -m jdk.httpserver/sun.net.httpserver.SimpleFileServer --port 8000 --path .


## Java 19 (Released September 2022)

### 1. Virtual Threads (Preview) (JEP 425)
- **Description**: Introduces lightweight threads that ease concurrent programming by treating many tasks as separate threads without the overhead of traditional threads.
- **Comparison**: Managing a large number of concurrent tasks used to involve complex thread pool management.
- **Java 19 Example**:
```java
  try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> System.out.println("Hello from Virtual Thread!"));
  }
```

## Java 20 (Released March 2023)

### 1. Record Patterns (Preview) (JEP 405)
- **Description**: Enhances the language with record patterns to deconstruct record values.
- **Comparison**: Deconstructing records required explicit method calls previously.
- **Java 20 Example**:
```java
  record Point(int x, int y) {}
  Point p = new Point(1, 2);
  if (p instanceof Point(int x, int y)) {
    System.out.println("x: " + x + ", y: " + y);
  }
```

## Java 21 (Released September 2023)

### 1. Scoped Values (Incubator) (JEP 429)
- **Description**: Introduces scoped values as a way to pass context through a chain of method calls.
- **Comparison**: Previously, passing context required threading parameters through multiple method calls.
- **Java 21 Example**:
```java
  try (var scope = ScopedValues.with(SCOPE_KEY, "MyValue")) {
  // Access the scoped value
  }
```  
### Unnamed Variables
```java 
if (r instanceof Point(int x, _)) {
  // work with x, ignore second parameter
}
```

