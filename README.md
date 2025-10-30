# KTH-ID1021 – Algorithms and Data Structures

This repository contains all programming assignments and reports for the **ID1021: Algorithms and Data Structures** course at **KTH Royal Institute of Technology**.  
The course focuses on the theoretical and practical aspects of algorithm efficiency, data organization, and computational complexity.

Each subfolder represents a major module or lab exploring a particular algorithmic paradigm, data structure, or problem-solving approach using **Java**.

---

## 📘 Course Overview

**Course:** ID1021 – Algorithms and Data Structures  
**Institution:** KTH Royal Institute of Technology  
**Language:** Java  
**Focus Areas:**
- Algorithm design and analysis (time & space complexity)
- Sorting, searching, and data structure implementation
- Recursion and divide-and-conquer
- Linked lists, stacks, and queues
- Trees and graphs
- Hashing and symbol tables
- Shortest-path algorithms (Dijkstra)
- Benchmarking and performance evaluation

---


Each folder contains:
- `.java` source files implementing algorithms
- `.pdf` reports describing methods, results, and theory
- Optional `.csv` or `.py` files for benchmarking and data visualization

---

## 🧩 Module Descriptions

### 🔹 Arrays/
**Goal:** Introduction to algorithmic thinking and array manipulation.  
Includes:
- Sequential iteration and basic array algorithms  
- Timing experiments with simple loops  
- Comparison of different implementations  
- `arrays-java.pdf` and `Arrays.pdf` explain theoretical background  

---

### 🔹 LinkedLists/
**Goal:** Implement and analyze the performance of linked lists.  
- Singly linked list (`LinkedList.java`) with inner `Cell` class  
- Benchmarking performance for appending and traversal  
- Graph generation via Python (`benchmark_graph.py`)  
- Report: `LinkedList.pdf`

---

### 🔹 Queues/
**Goal:** Compare different queue implementations and measure their efficiency.  
Includes:
- `Queue.java`: basic linked queue  
- `QueueTail.java`: optimized queue with tail pointer  
- `Benchmark.java`, `Benchmark2.java`: time measurement scripts  
- Benchmark plots in `.pdf` generated via `BenchmarkGraph.py`  
- Report: `Queues.pdf`

---

### 🔹 Hash/
**Goal:** Implement hash tables and analyze collision strategies.  
Covers:
- **Direct indexing** and **hash functions**
- **Open addressing** and **bucket chaining**
- Benchmarks using `postnummer.csv` (Swedish postal codes)
- Key classes:
  - `Zip.java`, `ZipWithBuckets.java`, `ZipOpenAddressing.java`
  - `StringBenchmark.java`, `ZipBenchmark.java`
- Report: `Hash.pdf`

---

### 🔹 Searching/
**Goal:** Implement and analyze search algorithms.  
Algorithms covered:
- Linear search (`unsorted_search.java`)
- Binary search (`binary_search.java`)
- Recursive search (`recursive.java`)
- Sorted search optimizations (`sorted.java`)
- Report: `Searching.pdf`

---

### 🔹 Sorting/
**Goal:** Compare different sorting algorithms and their complexities.  
Implemented algorithms:
- `InsertionSort.java`
- `SelectionSort.java`
- `MergeSort.java`
- `OptimizedMergeSort.java`
- Each algorithm tested for runtime and memory behavior  
- Report: `Sorting.pdf`

---

### 🔹 Trees/
**Goal:** Understand tree-based data structures and traversal.  
Includes:
- `BinaryTree.java` (insert, search, traversal)
- `BinaryTreeTest.java` and `BinaryTreeBenchmark.java`
- Recursive and iterative traversal performance
- Visualization using `Graph.py`

---

### 🔹 Bfs/
**Goal:** Implement Breadth-First Search (BFS) using trees and queues.  
Includes:
- `BinaryTree.java`, `Queue.java`, `TreeNode.java`
- `Main.java` for BFS traversal demonstration
- Concept illustrated in `Bfs.pdf` and `NodesTree.pdf`

---

### 🔹 Graphs/
**Goal:** Explore graph representations and pathfinding.  
Features:
- Graph structures using adjacency lists and hash tables
- `TrainMap.java`, `TrainMapWithHash.java`, `City.java`, `Connection.java`
- Pathfinding algorithms (naive and optimized)
- Datasets: `trains.csv`
- Report: `Graphs.pdf`

---

### 🔹 Dijkstra/
**Goal:** Implement **Dijkstra’s shortest path algorithm**.  
Includes:
- `City.java`, `Connection.java`, `Map.java`
- `Dijkstra.java` and `PathQueue.java` implementing the algorithm
- Benchmarking using `DijkstraBenchmark.java`
- Datasets: `trains.csv`, `europe.csv`
- Report: `Dijkstra.pdf`

---

### 🔹 HP35/
**Goal:** Simulate the HP-35 scientific calculator using stack-based operations.  
Concepts covered:
- Stack implementations: `StaticStack.java` and `DynamicStack.java`
- Reverse Polish Notation (RPN)
- Binary operations and arithmetic logic
- Report: `HP35.pdf`

---

### 🔹 T9/
**Goal:** Implement predictive text input using the T9 algorithm.  
Features:
- Trie-based dictionary lookup (`T9.java`)
- Sample dictionaries: `kelly.txt`, `kelly1.txt`
- `TestT9.java` for validation and performance testing
- Report: `T9.pdf`
