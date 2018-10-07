#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct  7 13:47:44 2018

@author: habhavsar
"""


def minCostClimbingStairs(cost):
    finalCost1 = 0
    finalCost2 = 0
    #for c in cost[::-1]:
    for c in reversed(cost):
        
        finalCost0 = c + min(finalCost1, finalCost2)
        finalCost2 = finalCost1
        finalCost1 = finalCost0
    
    
    return min(finalCost1, finalCost2)


cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]


ans = minCostClimbingStairs(cost)

print(ans) 


def minCostClimbingStairsFWD(cost):
    old = cost[0]
    current = cost[1]
    
    for c in cost[2:]:
        temp = current
        current = c + min(old, current) 
        old = temp
    
    return min(old, current)

ans = minCostClimbingStairsFWD(cost)

print(ans)