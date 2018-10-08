#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct  7 18:53:40 2018

@author: habhavsar
"""

import sys

def maxSubArray(nums):
    current = 0
    ans = -sys.maxsize - 1
    for i in range(0, len(nums)):
        current += nums[i]
        if(current > ans):
            ans = current
    
        if(current < 0):
            current= 0
    return ans


nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]     

ans = maxSubArray(nums)
print(ans)