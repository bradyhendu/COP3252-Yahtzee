---
runme:
  id: 01HH0FNPSS5GZX0W2WF11NJV7P
  version: v2.0
---

# COP3252-Yahtzee

This is the repository where we will implement the Yahtzee game in Java. This is for our final assignment for COP3252

## How to use the Interface

The screen is a fixed sized. The buttons are labeled with the name of the action they perform. The buttons are as follows:

- Roll Dice: Rolls the dice. You can roll up to 3 times per turn.
- Score: Scores the dice. You can only score once per turn.
- Play Game: Plays the game, stays at the current state so if you leave a game to go check the rules in the middle of the round you can return back to the game.
- Back to Main Menu: Goes back to the main menu.
- Stop Rolling: Stops rolling the dice. You can only stop rolling if you have rolled at least once.
- Rules: Shows the rules of the game.
- Scoreboard: There are labels to the left of the buttons you would press when you want to submit a score for that row. The score button's text will change based on the Dice's values so you can see how many points you'll get for that row. The score button will be disabled if you have already scored for that row.

## How to compile

To compile the program, to run the program, or to use the jar file, you must have Java 8 installed. You can download it from [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). 

Once you have Java 8 installed, you can compile the program by running the following command in the root directory of the project:

```javac \Yahtzee.java```

## How to run

Once you have Java 8 installed, you can run the program by running the following command in the root directory of the project:

```java Yahtzee```

## How to use the Jar file

 Once you have Java 8 installed, you can run the jar file by running the following command in the root directory of the project:

```java -jar hwx.jar```
