# Java Project: TicTacToe

* Authors: Luca Bova & Chad Long
* Class: IST-4-JAV
* IST Fall Semester

## Overview

This program is an implementation of TicTacToe, a two-player game where the objective 
is to make a row of 3 'X's on a 3x3 grid. This utilizes three classes: a GUI, a driver, 
and an interface. 

## Reflection 
Developing this game had interesting limitations. Because the GUI was provided, i had to work whithin the parameters
it allowed in order to get the game to function. I did this by reviewing the GUI and how it wanted to function. I then went to work implementing my main method. I first imported my abstract 
interface that defined all of my parameters that i would need for the game, and then i set to work utilizing
those parameters. Easily the most difficult thing was getting the computer to choose a tile
and allowing it to win. This was implemented by having the computer check each possible tile and checking
its assigned value, and seeing if it was possible to make a legal move. The most
tedious aspect of this project was checking for game overs. Everytime gameover is called, it checks every single tile
on the gameboard and checks for all possible permutations of a game over status. This ended up working
but assigning every grid value to check manually was time consuming. Overall, this was a fun and challenging project
to work on and ensuring i utilized an abstract as well as an interface was a challenge, admittedly one we met.

## Compiling and Using
Download the .java files from the repository, and run the GUI. The game will begin.

## Sources used
The GUI was supplied to me for a previous project. However, this project is heavily modified in order
to meet the requirements for this new assignment. We modified and utilized an abstract and an interface.
Those are all the sources we used.
