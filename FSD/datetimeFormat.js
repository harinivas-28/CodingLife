/*
You are given a date-time string dt in the format YYYY-MM-DDTHH:MM:SS (24-hour format). 
Your task is to convert this date-time string into the following format:

Input Format:
-------------
Line-1: A single date-time string in the format YYYY-MM-DDTHH:MM:SS (24-hour format).

Output Format:
--------------
Line-1: The formatted date-time string in the format :
DaySuffix MonthName, Year Hour:Minute:SecondAM/PM.

Sample Input-1:
---------------
2019-07-18T16:34:21

Sample Output-1:
----------------
18th July, 2019 04:34:21PM


Sample Input-2:
---------------
2022-03-01T23:59:59

Sample Output-2:
----------------
1st March, 2022 11:59:59PM

NOTE:
The output should include:
	Day with an ordinal suffix (e.g., 18th)
	Month as a word (e.g., July)
	12-hour time format with AM/PM

*/

const readline = require('readline');

// Set up readline interface for reading input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to convert date string
const convertDateString = (dateStr) => {
    const date = new Date(dateStr);
    
    // Get date components
    const day = date.getDate();
    const month = date.getMonth();
    const year = date.getFullYear();
    let hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    // console.log(day, month, year, hours, minutes, seconds);
    
    // Add ordinal suffix to day
    const getDaySuffix = (day) => {
        if (day >= 11 && day <= 13) return 'th';
        switch (day % 10) {
            case 1: return 'st';
            case 2: return 'nd';
            case 3: return 'rd';
            default: return 'th';
        }
    };
    
    // Convert month number to name
    const monthNames = [
        'January', 'February', 'March', 'April', 'May', 'June',
        'July', 'August', 'September', 'October', 'November', 'December'
    ];
    
    // Convert to 12-hour format
    const period = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12 || 12;
    
    // Format the string
    return `${day}${getDaySuffix(day)} ${monthNames[month]}, ${year} ` +
           `${String(hours).padStart(2, '0')}:${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}${period}`;
};

// Function to read input and process the date string
const processDateInput = () => {
  rl.question("", (input) => {
    const formattedDate = convertDateString(input);
    console.log(formattedDate);
    rl.close();
  });
};

// Start the process
processDateInput();
