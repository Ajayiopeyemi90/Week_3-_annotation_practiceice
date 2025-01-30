# Week_3-_annotation_practiceice

## Overview
This project demonstrates the use of custom Java annotations to document enhancement requests such as bug fixes or feature improvements. The annotation `@EnhancementRequest` can be applied to **classes, methods, and constructors**, and it is retained at **runtime** for reflective processing.

## Features
- Defines a custom annotation `@EnhancementRequest`.
- Uses `@Target` to limit annotation usage to **classes, methods, and constructors**.
- Uses `@Retention(RetentionPolicy.RUNTIME)` to allow retrieval via reflection.
- Demonstrates annotation processing using Java reflection.

## Annotation Definition
The `@EnhancementRequest` annotation has the following fields:
- `Id` (int): A unique identifier for the enhancement request.
- `Sypnosis` (String): A brief description of the request.
- `Engineer` (String, default: "undefined"): Name of the engineer handling the request.
- `Date` (String, default: "Unknown"): The date of the request.

## Code Structure

### **1. Annotation Definition (`EnhancementRequest.java`)**
```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnhancementRequest {
    int Id();
    String Sypnosis();
    String Engineer() default "undefined";
    String Date() default "Unknown";
}
```

### **2. Applying the Annotation (`BugFixClass.java`)**
```java
@EnhancementRequest(Id = 20241023, Sypnosis = "Fix bug", Engineer = "Opeyemi")
public class BugFixClass {
    // Class definition
}
```

### **3. Reading Annotations at Runtime (`Main.java`)**
```java
public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = BugFixClass.class;
        if (clazz.isAnnotationPresent(EnhancementRequest.class)) {
            EnhancementRequest annotation = clazz.getAnnotation(EnhancementRequest.class);
            System.out.println("ID: " + annotation.Id());
            System.out.println("Synopsis: " + annotation.Sypnosis());
            System.out.println("Engineer: " + annotation.Engineer());
            System.out.println("Date: " + annotation.Date());
        }
    }
}
```

## Expected Output
When running `Main.java`, the program will detect the `@EnhancementRequest` annotation on `BugFixClass` and print its values:

```
ID: 20241023
Synopsis: Fix bug
Engineer: Opeyemi
Date: Unknown
```

## How to Run the Program
1. **Compile the Java files**:
   ```sh
   javac EnhancementRequest.java BugFixClass.java Main.java
   ```
2. **Run the program**:
   ```sh
   java Main
   ```

## Conclusion
This project demonstrates how to create, apply, and retrieve custom annotations in Java. It showcases how annotations can be used for metadata tagging, specifically for tracking enhancement requests within a project.


### Author
Opeyemi | 2025

