# Coffee Machine

Credit: https://hyperskill.org/projects/33?track=1

## About
What can be better than a cup of coffee during a break? A coffee that you don’t have to make yourself.
It’s enough to press a couple of buttons on the machine and you get a cup of energy; but first, we should teach the machine how to do it.
In this project, you will work on programming a coffee machine simulator.
The machine works with typical products: coffee, milk, sugar, and plastic cups; if it runs out of something, it shows a notification.
You can get three types of coffee: espresso, cappuccino and latte. Since nothing’s for free, it also collects the money.

## Current Stage #6: Brush your code
Time for some final touch-ups: structure the code so that it runs smoothly.

Description

Let's redesign our program and write a class that represents the coffee machine. The class should have a method that takes a string as input. Every time the user inputs a line (a string) to the console, the program invokes this method with one argument: the line that user input to the console. This system simulates pretty accurately how real-world electronic devices work. External components (like buttons on the coffee machine or tapping on the screen) generate events that pass into the single interface of the program.

The class should not use system input at all; it only should handle input that comes to it via this method and its string argument.

The first problem that comes to mind: how to write that method in a way that it represents all that coffee machine can do? If the user inputs a single number, how can the method determine what that number is: a variant of coffee chosen by the user or the number of the disposable cups that a special worker added into the coffee machine?

The right solution to this problem is to store the current state of the machine. The coffee machine has several states it can be in. For example, the state could be "choosing an action" or "choosing a variant of coffee". Every time the user inputs something and a program passes that line to the method, the program determines how to interpret this line using the information about the current state. After processing this line, the state of the coffee machine can be changed or can stay the same. The most efficient way of handling states is using an enum with all predefined states.

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4. For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7. And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.