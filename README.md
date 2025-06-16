# Java Binary Search Tree & Dictionary App – COMPX201 Assignment 2

This project implements an **unbalanced binary search tree (BST)** in Java and extends it into a **console-based dictionary application**. Built for COMPX201 at the University of Waikato (2024), the project is divided into two parts: core BST functionality and a dictionary file reader with interactive lookup features.

---

## 🌲 Part One – StrBST: String Binary Search Tree

### ✅ Features
- `insert(String s)` – Inserts a string alphabetically (no duplicates)
- `remove(String s)` – Removes a string from the tree
- `search(String s)` – Returns `true` if a string exists
- `print()` – In-order traversal output of the tree

### 📁 Structure
```plaintext
StrBST.java           # BST logic
Node.java             # Node class with left/right child references
```

---

## 📖 Part Two – DictionaryBST: String + Definition Dictionary Tree
Extends the base BST to store (word, definition) pairs.

### ✅ New Features
- insert(String word, String definition)
- printDictionaryItem(String word) – Print a word and its definition
- printDictionary() – In-order print of all entries (word + definition)

### 🧠 Classes
- Copy
- Edit
- DictionaryBST.java       # BST class extended for dictionary
- DictionaryNode.java      # Node class with definition field
- DictionaryLookup.java    # Main program to load, manage, and query dictionary

--- 

## 🖥️ DictionaryLookup Console Application
An interactive CLI app that loads a dictionary file and allows:

1. 🔍 Search for a word
2. 📖 Print word + definition
3. ➕ Add a new word/definition
4. ❌ Remove an entry
5. 📚 Print all entries alphabetically


## Sample Output

```plaintext
Loading dictionary from file ...

Welcome to the Dictionary Lookup!

Please enter a number to indicate what you would like to do
(1) Search for a word/phrase in the dictionary
(2) Print a given word/phrase and it's definition
(3) Add a word/phrase and definition to the dictionary
(4) Remove a word/phrase and definition from the dictionary
(5) Print all of the words/phrases and their definitions, in alphabetical order
(6) Exit
```

---

## 🛠 How to Compile & Run

# Compile all
javac *.java

# Run dictionary program
java DictionaryLookup

---

## 🧪 File Structure
```plaintext
bst-dictionary-app/
├── StrBST.java
├── Node.java
├── DictionaryBST.java
├── DictionaryNode.java
├── DictionaryLookup.java
└── README.md
```

## 👨‍🎓 Author
Lucas Oda
University of Waikato
COMPX201 – Data Structures & Algorithms (2024, April)

