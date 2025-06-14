package PYQ;
import java.util.*;
/*
A cybersecurity expert has just intercepted a transmission from a group of cybercriminals. The transmission contains an array arr of binary codes, which represents some confidential information. However, after a thorough analysis, the expert discovered a vulnerability in the encryption method. An array is considered to be compromised if the bitwise OR of all elements in the subarray is present in the array itself.

The goal is to find the number of compromised subarrays in the intercepted transmission and prevent the cybercriminals from exploiting this weakness in their encryption.

Note: A subarray is defined as any contiguous segment of the array.

Example

Given, n=3 and arr=[2,4,7].

Subarray	Bitwise OR	Is compromised?
2	2	Yes
2, 4	6	No
2, 4, 7	7	Yes
4	4	Yes
4, 7	7	Yes
7	7	Yes

Export to Sheets
Hence the answer is 5.

Function Description

Complete the function getCompromisedSubarrayCount in the editor below.

getCompromisedSubarrayCount takes the following arguments:
int arr[n]: the input array

Returns

long int: the number of compromised subarrays in the array

Constraints

1≤n≤10
5

1≤arr[i]≤10
6
 */
public class CompromisedSubarrayCount {
}
