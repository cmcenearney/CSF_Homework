/*

advanced data structures - maps, sets and graphs
================================================

maps
----
key/value pairs. same as hash
- unordered
- key is typically an object and must be unique  among set of keys
- value typically an object

java provides
    - treemaps (backed by a tree) and
    - hashmaps (backed by an array - reliant on hash function to convert key to array index)
        - hash function must
            - return fixed size output for variable size input
    - HashMaps hash the key, mod by number of buckets
    - con: need to make new arrays + copy everything when the backing array runs out of space
       and  *rehash* , recalculate every objects position
    - can be done all at once, or incrementally
         - **collisions**
            - open addressing - bucket is already taken, keep looking until find an open spot
            - chaining - each bucket contains a linked list of keys/values, when you hit a filled bucket, look through the list
            - hybrids of the above


graphs
------
 models
 no data in edges:
    - adjacency list - list of N nodes, where each node has a list of nodes that it's is connected to
    - adjacency matrix

 data in edges:
    - incidence lists
    - incidence matrix

 */


