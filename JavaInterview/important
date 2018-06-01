INTERV - 1
1) Dynamic Programming
2) Super recursion (permutation, combination,...2^n, m^n, n!...etc. type of program. (NP hard, NP programs)
3) Probability related programs
4) Graphs: BFS/DFS are usually enough
5) All basic data structures from Arrays/Lists to circular queues, BSTs, Hash tables, B-Trees, and Red-Black trees, and all basic algorithms like sorting, binary search, median,...


INTERV - 2
1) A string consists of ‘0’, ‘1’ and '?'. The question mark can be either '0' or '1'. Find all possible combinations for a string.
2) Give you a text file, remove duplicated lines. Follow up: If the file is very large, general hash map takes too much spaces, come up with a better solution.

INTERV - 3
1) BFS/DFS on a 2D matrix with certain extra conditions using   given functions

INTERV - 4
1) some basic string manipulation and 2d array questions, also asked about data structures and when to use which.
(String buffer - String builder - String)

INTERV - 6
1) hash tables (basic knowledge, know what they do, how to use them), DFS and BFS on trees - know the difference between a binary tree and a binary search tree.

INTERV - 7
1) Write an algorithm to return the highest product of primes in an array.

INTERV - 8
1) Given two lists A and B containing sorted non-unique   integers, return the elements in A but not B and the elements in B but not A.
2) Make a data structure for adding numbers, removing numbers   , and returning the median. Give the O(n) time of each operation.
----------------------
COMMENT : You could use a min and a max heap to keep track of the lower and upper half and rebalance if one grows at least 2 bigger than the other.
The rebalancing would take O(lg(n)) (and only when it needs to occur) which means inserts and removals are only O(lg(n) + lg(n)) = O(lg(n))
and median value is just a comparison of the top of the max heap for the lower end and the top of the min heap for the upper end in O(1).
If median isn't called much inserts/deletes could be O(1) if you just fill a list and then only find the the median in O(n) time by doing a typical kth smallest
where k = n/2 or n/2 and n/2 + 1 if in is odd.

INTERV - 9
1) return the biggest inclusive interval given the tuples

INTERV - 10
1) Every city has a calendar with different holiday periods. You may travel to another city only at the weekend.
What is the maximum days of holiday that you can get in a year.
----------------------
COMMENT : Dynamic Programming with a matrix. One dimension is city other is time.

2) When typing on the cellphone, how do you auto complete the possible words after two letters typed. Follow-up: How to rank the words if they are weighted by frequency.
----------------------
COMMENT : Trie + DFS
          Follow up: record the frequency of letter in node and search the more frequent nodes first.

3) Regex to validate email address
4) Regex to validate phone

INTERV - 11
1) Linked list, two sum of linked list
2) search in a dictionary recursively to find word

INTERV - 14
1) Given a count and maxvalue, write a program to return count number of unique random integers between 0 and maxvalue.

INTERV - 15
1) Find the longest path in a travel flights path which is a directed acyclic graphic

INTERV - 16
1) Eggs can be very hard or very fragile, which means they may break if dropped from the first floor or may not even break if dropped from 100th floor. Both eggs are identical. You need to figure out the highest floor of a 100-story building an egg can be dropped without breaking. The question is how many drops you need to make. You are allowed to break two eggs in…
-------------------------------
COMMENT : The idea should be used to use something like binary search, we first try to drop it from 50th floor and then so on, so in worst case / max steps will be required 49 i gues

INTERV - 17
1) One question involved creating a collection of the longest  common phrases between two strings.
---------------------------------
COMMENT : Pretty simple, created a list of common starting words, found longest continuous paths beginning at starting words,

INTERV - 18
1) How to implement union find? longest palindrom

INTERV - 19
1) Given a list of directed edges, find number of pairs of reciprocal edges

INTERV - 20
1) it was on tree and graph traversal

INTERV - 21
1) Given two int arrays A and B, and an int c, return the total number of pairs (a, b) where a is from A and b is from B, and a + b <= c
1) priority queue
1) Implement a FIFO queue using a singly linked list. How to insert locks into the enque and deque function to prevent simultaneous access by multiple threads.
1) Questions on graph searching (think DFS, BFS), tree traversal (think inorder, preorder, postorder), array and string manipulation
1) Max squares in a rectangle
1) Invert a binary tree.
1) merge two sorted lists.
1) converting a large decimal to binary
1) Given a node in a BST where each node has a pointer to its parent, find the next largest node
1) Implement String encode and decode
1) Given an int array A, return an int array B that A[i   + B[i]] is the first element in A after A[i] that is greater than or equal to A[i]
-------------------------------
Comment : Allocate array B of the same size as A.

          set B[size - 1] = 0. // size of Array A.

          for each element x from size - 2 down to 0:
              j := x + 1
              if A[x] <= A[j]:
                       B[x] = 1;
              else:
                       while j < size AND j + B[j] != j :
                                if A[x] <= A[j + B[j]]:
                                           break
                                else:
                                           j = j + B[j];
                       B[x] = j + B[j] - x;

          The complexity of above algorithm is O(n).
1)  Design twitter trending topic with Hasmap
1)  Given a list of files, each of which contains some "require   METHOD_NAME" lines, and "provide METHOD_NAME" lines. Return a working order of files to be processed.
Typical Topological sort question, use DFS
1) Implement a telephone # management system that assign randomly, recycle and check availability of 10 digit numbers.
-----------
Comment :
Use queue for unused numbers (initially randomly shuffled) and hashmap for used numbers.
Get unused number -> dequeue O(1)
Check if number is used -> search in hashmap O(1)
Recycle -> remove from hashmap O(1) and insert in the queue O(1)

1) Given an NxN matrix how would you print all elements in a spiral way starting from the middle element. ANSWER: 4 for loops with conditions.
1) Design a HashMap. Topological Sort
1) Write an efficient method to find the first non-repeated character in a string. Example: the first non-repeated character in “teeters” is “r”.
 ----
 Comment :

public static char firstNonRepeatedCharacter(String str) {
        int[] store = {-1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1,
                -1, -1
        };

        char[] chars = str.toCharArray();
        for (int i = 0; i = 0) {
                    store[chars[i] - 'a'] = -2;
                } else {
                    store[chars[i] - 'a'] = i;
                }
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i = 0) {
                if (store[i] < minIndex) {
                    minIndex = store[i];
                }
            }
        }
        return chars[minIndex];
    }

1) Given a list of words, develop two functions to serialize and deserialize into a single string.
   Given a string in the format: 2(abc)4(df), write a function to decompress the string to the following format: abcabcdfdfdfdf

1) Given three operations (UPDATE a character, DELETE a character, and ADD a character) and a string, give the minimum number of operations required to convert the string to a palindrome.
1) given an array of n integers, check if the array has two nearby duplicate numbers
1) gas station problem, solved by Dynamic programming
1) Correct binary search tree
1) time complexity of fibonacci
1) range sum immutable & mutable
1) Given 3 coins of different values, print all the sums of   the coins up to 1000. Must be printed in order. ex: coins(10, 15, 55) 10 15 20 25 30 . . . 1000
1) Implement custom iterator
1) find longest palindrom from string, O(N) runtime
1) 2D binary index tree
1) giving a list of numbers and a target number, find all the combination of numbers which is smaller or equals to the target.
   eg: if list is {3,7,8} and target is 8700, then 3, 8, 7 ... 333, 888, ... , 8377 are all possible numbers.
1) Giving a string and an string dictionary, find the longest string in dictionary which can formed by deleting some characters of the giving string.
   eg:S = abpcplea, Dict = {ale, apple, monkey, plea}, the return "apple"
1) Write a function that determines if a list of integers is in the same order as a second list of integers.
        Do not assume the first list is distinct/unique
        Do assume the second list is.

        s1: [6,4,2,8,9,6,2,2]
        s2: [4,2,9]
        output: True

1) Q: String encoding and decoding: Design a method that converts a list of strings into a single string which can be later converted back to the list.
1). Unique Word Abbreviation
1)  Valid Anagram
1) The vending machine has 3 buttons A, B and C. But when you   press A, there is a range of volume of drink you will get. For example: A: 200 ml - 210 ml B: 500 ml - 510ml C: 700 ml - 710 ml You have a bottle that has a lower range and upper range. You could press any buttons many times, but you have to make sure that once you got a soda you pour it into the bottle. Makes sure that all the soda you got fall into the range of the bottle. Find all the combinations of buttons to press that allow you to fill in your bottl
using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var ranges = new Dictionary(){
            {100, "A" },
            {200, "B" },
            {300, "C" }
        };

        int low = 10;
        int high = 15;

        var x = ranges.Values.SelectMany(l => l);

        var result = Perms(ranges, 150, 350, new List());

        foreach (var answer in result){
            Console.WriteLine(string.Join(", ", answer));
        }
    }

    public static List> Perms(Dictionary ranges, int low, int high, List buttonsPressed){
    var result = new List>();
        if (low = 0){
                result.Add(buttonsPressed);
            }
            return result;
        }
        else {
            foreach (int volume in ranges.Keys){
                var newButtons = buttonsPressed.Select(b => b).ToList();
                newButtons.Add(ranges[volume]);
                result.AddRange(Perms(ranges, low - volume, high - volume, newButtons));
            }
        }
        return result;
    }
}
