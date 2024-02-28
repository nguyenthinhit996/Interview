# New Features in Java 9, 10, and 11
## Module System
## JShell (Interactive Java REPL)
## Local Variable Type Inference
## Local Variable Syntax for Lambda Parameters

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