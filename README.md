# afl-challenge

This repository contains my source code for the AFL coding challenge.
The project is configured as a gradle (https://gradle.org/) project.

There are two applications contained within this repository:

##Childrens Game Simulator

This application can be run by invoking `gradle runGame`

The user will be prompted to input the number of children playing the game (n),
and the number of children to count before an elimination occurs (k).

The application will print id of the winning child to the console, as well
as the sequence in which the other children were eliminated.



##Number Iterator

This project can be run by invoking `gradle runIterator`

The user will be prompted to input the number to iterate up until.

The application will print to the console any numbers which match the predefined rules, and their corresponding outputs.

Some allowance has been made for ease of flexibility in adding rules. A design decision I have made is that the application developer is responsible for ensuring that rules are mutually exclusive (rather than forcing this logic into the application). This is because the exact behaviour required for additional rules is not fully known at this stage This would need to be re-examined when the new requirements are known.