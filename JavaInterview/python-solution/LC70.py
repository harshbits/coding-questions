#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct  7 14:27:27 2018

@author: habhavsar
"""


def climbStairs(i, n):
    if i > n:
        return 0
    
    if i == n:
        return 1
    
    return climbStairs(i + 1, n) + climbStairs(i + 2, n)
    
def climbStairs1(n):
    return climbStairs(0, n)


steps= 4
ans = climbStairs1(steps)
print(ans)


def climbStairsBU(n):
    if n == 1:
        return 1
    
    if n == 2:
        return 2
    
    return climbStairsBU(n - 1) + climbStairsBU (n - 2)

ans = climbStairsBU(steps)
print(ans)


def climbStairsDP(n):
    dp= [0] * (n+1)
    dp[1] = 1
    dp[2] = 2
    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2] 

    return dp[n]
    
    
ans = climbStairsDP(steps)
print(ans)
    