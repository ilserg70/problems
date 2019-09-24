import sys
import re
import random as rm
rm.seed(5)

def read_file(file_name):
    with open(file_name, 'r') as f:
        content = f.readlines()
    return [x.strip() for x in content]

def make_graph(file_name):
    content = read_file(file_name)
    g = {}
    for line in content:
        m = re.search('(.+) -> (.+)', line)
        if m:
            a, b = m.group(1), m.group(2)
            if a not in g:
                g[a] = set()
            g[a].add(b)
    for k in g.keys():
        g[k] = list(g[k])
    return g

def rand_walks(g, L, N):
    tracks = []
    m = N*N
    while N > 0 and m > 0:
        p = [rm.choice(list(g.keys()))]
        while len(p) < L:
            e = p[-1]
            if e not in g:
                break
            p.append(rm.choice(g[e]))
        if len(p) == L:
            tracks.append(p)
            N -= 1
        m -= 1
    return tracks


def main(): # Command line arguments: L N "file path"
    L, N, file_name = 4, 10, "random_walks_graph.txt"
    
    args = sys.argv[1:]
    if len(args) > 1:
        L, N = int(args[0]), int(args[1])

    if len(args) > 2:
        file_name = args[2]

    print(f"\nInput: file: '{file_name}', L={L}, N={N}")

    g = make_graph(file_name)
    print(f"\nGraph: {g}")

    tracks = rand_walks(g, L, N)
    print("\nRandom walks:")
    for p in tracks:
        print(p)

if __name__ == '__main__':
    main()