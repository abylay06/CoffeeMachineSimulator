# Coffee Machine – Java Console Application

A console-based Java application that simulates the behaviour of a coffee machine.

The project was built to strengthen my understanding of **Java Core**, **object-oriented programming**, state management, collections, input handling, and program structure.

## Features

The coffee machine supports the following operations:

- Buy espresso, latte, or cappuccino
- Check whether enough resources are available
- Refill water, milk, coffee beans, and disposable cups
- Collect money from the machine
- Display the current machine resources
- Maintain the machine's current operating state
- Reject invalid actions when appropriate

## Technologies

- Java
- Java Collections Framework
- `ArrayList`
- `Scanner`
- Object-Oriented Programming

## Java Concepts Practised

This project demonstrates several Java Core and OOP concepts.

### Encapsulation

The internal state of the coffee machine is stored in private fields:

```java
private int water;
private int milk;
private int beans;
private int cups;
private int money;
private String state;
```

The values are accessed and modified through methods rather than directly from `Main`.

### Object-Oriented Design

The application separates responsibilities between classes:

- `Main` handles user input and the main application loop.
- `CoffeeMachine` contains the machine state and business logic.

This keeps input handling separate from the behaviour of the coffee machine.

### State-Based Behaviour

The machine behaves differently depending on its current state.

Examples:

```text
action
buy
water
milk
beans
cups
```

For example, after the user enters `fill`, the machine changes through several states:

```text
action → water → milk → beans → cups → action
```

This allows one `operate()` method to process commands according to the current state of the machine.

### Collections

`ArrayList<String>` is used to collect all missing resources when checking whether a drink can be prepared.

Example:

```java
ArrayList<String> notEnough = new ArrayList<>();

if (this.water < water) {
    notEnough.add("water");
}

if (this.milk < milk) {
    notEnough.add("milk");
}
```

Instead of returning only a boolean, the program can report exactly which resources are missing.

Example output:

```text
You dont have enough of water, beans
```

### Resource Validation

Before preparing a drink, the machine checks whether sufficient ingredients and disposable cups are available.

For example, espresso requires:

```text
250 ml water
16 g coffee beans
1 disposable cup
```

Resources are deducted only when the machine has everything required.

## Available Drinks

| Drink | Water | Milk | Beans | Price |
|---|---:|---:|---:|---:|
| Espresso | 250 ml | 0 ml | 16 g | $4 |
| Latte | 350 ml | 75 ml | 20 g | $7 |
| Cappuccino | 200 ml | 100 ml | 12 g | $6 |

## Example

```text
Write action (buy, fill, take, remaining, exit)
buy

Choose coffe: 1, 2, 3.
2

Yes we can make it!

Write action (buy, fill, take, remaining, exit)
remaining

The coffee machine has:
50 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money
```

## Project Structure

```text
src/
├── Main.java
└── CoffeeMachine.java
```

### `Main.java`

Responsible for:

- Reading user commands
- Running the main application loop
- Sending commands to the coffee machine
- Exiting the application

### `CoffeeMachine.java`

Responsible for:

- Machine resources
- Machine state
- Coffee preparation
- Resource validation
- Filling the machine
- Taking money
- Displaying machine information

## Running the Project

Compile:

```bash
javac Main.java CoffeeMachine.java
```

Run:

```bash
java Main
```

## Planned Refactoring

The current implementation intentionally keeps the design simple while I practise Java Core concepts.

Possible improvements include:

- Replacing string states with a `MachineState` enum
- Replacing numeric coffee choices with a `CoffeeType` enum
- Moving drink recipes into objects or enums
- Replacing long `if / else if` chains with `switch`
- Adding custom exceptions for invalid commands
- Introducing logging
- Adding automated tests with JUnit
- Separating command handling into additional classes
- Applying design patterns where appropriate

For example, a future `CoffeeType` enum could encapsulate the properties of each drink:

```java
ESPRESSO(250, 0, 16, 4),
LATTE(350, 75, 20, 7),
CAPPUCCINO(200, 100, 12, 6);
```

This would remove duplicated coffee preparation logic and make the application easier to extend.

## What I Learned

While building this project, I practised:

- Java classes and objects
- Encapsulation
- Methods and constructors
- Conditional logic
- Application state management
- Collections
- Parsing user input
- Separation of responsibilities
- Refactoring duplicated logic
- Designing a small interactive console application

The project also helped me understand how a program can move from a simple procedural implementation toward a more structured object-oriented design.

## Next Steps

My next goal is to apply the same Java fundamentals in larger backend projects using:

- Spring Boot
- REST APIs
- PostgreSQL
- JDBC / JPA
- Exception handling
- Logging
- Unit testing
- Maven or Gradle
