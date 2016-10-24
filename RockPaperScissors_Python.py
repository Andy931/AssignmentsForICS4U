# Created by: Andy Liu
# Created on: Oct 1 2016
# Created for: ICS4U
# Assignment #2b
# This program calculates the max run of a string

import random
import sys

#Rock: 0; Paper: 1; Scissors: 2
#The function to determine who is winning or losing
def rockpaperscissors (userSelection, computerSelection):
    if userSelection == computerSelection:
        if userSelection == 0:
            print("Both players chose rock!")
        elif userSelection == 1:
            print("Both players chose paper!")
        else:
            print("Both players chose scissors!") #When both user's and computer's choices are the same

    if userSelection == 0: #When the user chooses rock
        if computerSelection == 1:
            print("You chose rock; Computer chose paper")
            print("Computer wins!")
        elif userSelection != computerSelection:
            print("You chose rock; Computer chose scissors")
            print("You win!")

    elif userSelection == 1: #When the user chooses paper
        if computerSelection == 0:
            print("You chose paper; Computer chose rock")
            print("You win!")
        elif userSelection != computerSelection:
            print("You chose paper; Computer chose scissors")
            print("Computer wins!")

    else:  #When the user chooses scissors
        if computerSelection == 0:
            print("You chose scissors; Computer chose rock")
            print("Computer wins!")
        elif userSelection != computerSelection:
            print("You chose scissors; Computer chose paper")
            print("You win!")

#Start of the main program
beginOrEnd = 0 #For choosing play again or not

while beginOrEnd == 0: #Loop the game until the user choose to end
    userChoice = eval(input("Make a move (0 = Rock; 1 = Paper; 2 = Scissors): \n"))
    computerChoice = random.randint(0, 2)
    if userChoice < 0 or userChoice > 2:
        print("Out of range, try again!")
    else:
        rockpaperscissors(userChoice, computerChoice) #Call the function
    beginOrEnd = eval(input("Play again? Start = 0, End = other\n")) #Ask the user to play again or end the game

print("The game is ended.")
sys.exit() #End the game