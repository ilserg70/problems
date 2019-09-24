#Random walks

##Task:

Write a program (in C or C++ or Python) that will read the graph from a file 
and take a parameter L and a parameter N. It should output N sequences that are
random walks of the graphof length L.

###For example:

Graph:
A -> B
B -> C
A -> C
D -> C
C -> D
E -> D

L = 3, N = 3

Output:
[A, B, C]
[E, D, C]
[A, C, D]

##Solution

See files: "random_walks.py" or "random_walks.ipynb"

###To run program with default arguments:

	`python3 random_walks.py`

###To run program with arguments L=4, N=7:

	`python3 random_walks.py 4 7`

###To run program with arguments L=4, N=7 and file="random_walks_graph.txt":

	`python3 random_walks.py 4 7 "random_walks_graph.txt"`

###To run program using "jupyter notebook"

	`jupyter notebook`
	open file: "random_walks.ipynb"

