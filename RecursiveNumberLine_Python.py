# Created by: Andy Liu
# Created on: Nov 14 2016
# Created for: ICS4U
# Assignment #5b
# This program This program generates a symmetric series of number recursively

import sys


# START of recursive function
def rec_number_lines(string_of_numbers, number_of_input, counter):
    # Determine if the number is greater than 5, if is, then start a new line to print the number line
    if (counter <= number_of_input):
        if counter > 5:
            string_of_numbers = string_of_numbers + str(counter) + "\n" + string_of_numbers
        else:
            string_of_numbers = string_of_numbers + str(counter) + " " + string_of_numbers
        rec_number_lines(string_of_numbers, number_of_input, counter+1)
    # Determine if counter reaches the limit, if does, print the numbers out
    else:
        print(string_of_numbers)
# END of function

# START of main program
# Let the user input a number
# Input
line_number = eval(input("Please enter an integer larger than 1 to see the recursive number line: \n"))

# Process and Output
# Determine if the number is an integer that less than 1
if (((line_number * 10) % 10 == 0) and (line_number >= 1)):
    rec_number_lines("", line_number, 1)
else:
    print("Invalid input, try again!")
    sys.exit()
# END of program