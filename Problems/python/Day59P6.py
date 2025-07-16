
'''
Write a python program to read a comma-separated values file and print its 
contents in table format, replacing commas with tabs or spaces.

Input File: 
------
file.csv

Output:
-------
name age
John 20
Jane 25

Explanation:
-------------
File contains:- 

name,age
John,20
Jane,25

'''

def print_csv(filename):
    try:
        with open(filename, 'r') as file:
            for line in file:
                parts = line.strip().split(',')
                print('\t'.join(parts))
    except FileNotFoundError:
        print(f"File {filename} not found.")

s = input() # Coding/python/file.csv
print_csv(s)