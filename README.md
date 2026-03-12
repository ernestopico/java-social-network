# Java Social Network Analyzer

A Java-based social network analyzer that models user connections as a graph and applies BFS to find network centers and calculate eccentricity.

## Features
- Load accounts and connections from CSV files
- BFS (Breadth-First Search) to calculate distances between accounts
- Find the network center (most central account)
- Calculate eccentricity for each account
- Includes a Lord of the Rings test dataset

## Classes
- **Account** – Represents a user account with distance and eccentricity fields
- **Network** – Extends HashMap to model the social graph
- **GraphAlgorithms** – Implements BFS and network center algorithms
- **Main** – Loads data from CSV and runs the analysis
- **Test** – Unit tests using a LOTR-themed network

## How to Run
1. Compile all Java files:
```
   javac *.java
```
2. Run the program:
```
   java Main
```

## Technologies
- Java
- Graph algorithms (BFS)
- HashMap / LinkedList data structures
- CSV file parsing

## Author
Ernesto Pico – [GitHub](https://github.com/ernestopico) | [LinkedIn](https://www.linkedin.com/in/ernesto-pico-705957377)
