# 658. Find K Closest Elements

[![LeetCode Link](https://img.shields.io/badge/LeetCode-Problem_Link-FFA116?style=flat-square&logo=leetcode)](https://leetcode.com/problems/find-k-closest-elements/)
![Difficulty](https://img.shields.io/badge/Difficulty-Easy-22c55e?style=flat-square)

## Problem Statement

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:


	|a - x| < |b - x|, or
	|a - x| == |b - x| and a < b


 
Example 1:


Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]


Example 2:


Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]


 
Constraints:


	1 <= k <= arr.length
	1 <= arr.length <= 104
	arr is sorted in ascending order.
	-104 <= arr[i], x <= 104

## Examples

```
See problem description.
```

## Constraints

- |a - x| < |b - x|, or
- |a - x| == |b - x| and a < b

---
*Synced automatically with [AlgoVault](https://github.com/mr-sanjai-offl/AlgoVault)*