#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct  8 01:48:37 2018

@author: habhavsar
"""

class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
        
class Solution:
    
    def maxDepth(self, root):
       
        if root is None:
            return 0
        
        if root.children == []:
            return 1
        
        maxVal = 0
        for node in root.children:
            maxVal = max(maxVal, self.maxDepth(node))
        
        return maxVal + 1
    
        
        