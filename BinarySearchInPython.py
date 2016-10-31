# Created by: Andy Liu
# Created on: Oct 17 2016
# Created for: ICS4U
# Assignment #3b
# This program searches a number exists in an random array using binary search

from random import randint

array_size = 250  # define the size of the array

def binary_search(search_value, num):
    # these variables define a range for searching
    start_position = 0
    end_position = array_size - 1
    mid_position = int((end_position - start_position) / 2 + start_position + 0.5)

    # loop the process until the number is found
    while search_value != num[mid_position]:
        mid_position = int((end_position - start_position) / 2 + start_position + 0.5)
        if search_value > num[mid_position]:
            start_position = mid_position

        else:
            end_position = mid_position

        if end_position-start_position <= 1:
            if search_value == num[start_position]:
                return start_position
            elif search_value == num[end_position]:
                return end_position
            else:
                print("Not Found!")
                return -1
    return mid_position


def bubble_sort(number_list):

    flag = False  # set flag to false to begin first pass
    temp = 0  # holding variable

    while flag == False:
        flag = True  # set flag to true awaiting a possible swap

        for j in range(len(number_list)-1):

            if number_list[j] > number_list[j+1]:  # change to > for ascending sort
                temp = number_list[j+1]  # swap elements
                number_list[j+1] = number_list[j]
                number_list[j] = temp
                flag = False  # shows a swap occurred


# Main program starts
numberArray =[randint(1,2000) for i in range(0,array_size)]

bubble_sort(numberArray)  # call bubble sort function to sort the array

for counter in range(0, array_size):
    print("A[",counter,"] = ", numberArray[counter])  # print out the sorted array

# input
inputNumber = eval(input("Please enter an integer to search: \n"))  # input the number to search

# process
position = binary_search(inputNumber, numberArray)  # call binary search function to search the number

# output
print("The position of the number is", position)  # print out the position