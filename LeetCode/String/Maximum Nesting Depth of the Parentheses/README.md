# 1614. Maximum Nesting Depth of the Parentheses

[![LeetCode Link](https://img.shields.io/badge/LeetCode-Problem_Link-FFA116?style=flat-square&logo=leetcode)](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/)
![Difficulty](https://img.shields.io/badge/Difficulty-Easy-22c55e?style=flat-square)

## Problem Statement

Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 
Example 1:


Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.


Example 2:


Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.


Example 3:


Input: s = "()(())((()()))"

Output: 3


 
Constraints:


	1 <= s.length <= 100
	s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
	It is guaranteed that parentheses expression s is a VPS.

## Examples

```
See problem description.
```

## Constraints

- 1 <= s.length <= 100
- s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
- It is guaranteed that parentheses expression s is a VPS.

---
*Synced automatically with [AlgoVault](https://github.com/mr-sanjai-offl/AlgoVault)*