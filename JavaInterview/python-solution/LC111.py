#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct  8 06:25:58 2018

@author: habhavsar
"""



# Definition for a binary tree node.
class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None



q = queue.Queue()

q.put(1)

while not q.empty():
    print(q.get())
    

class Solution:
    
    #import queue 
    
    def minDepth(self, root):
        
        if root is None:
            return 0
        if root.left == None or root.right == None:
           return  1 + self.minDepth(root.left) + self.minDepth(root.left)
        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
            
        
        
        