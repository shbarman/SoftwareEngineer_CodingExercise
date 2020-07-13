# Consistent Hashing #

## Hashing ##

In a traditional hashing approach the hash of the key is attached to the server by the follwoing formula:

```
server = hash(key) mod N where N is the total number of servers;

```

So to add a new object we would need to calculate the  ``` hash modulo(N) ``` 


*Main idea : Keys and nodes map to the same ID space*

```
In terms of consistent hashing : In case of Nodes the id is Hash(IP Address)
                                 In case of Keys the id is Hash(Key)

 The key ids are mapped to the nodes by storing keys at its successor.                                   

```

![ConsistentHashing](/SystemDesign/images/conHash.png)

For scaling out we would have to insert distributed hashing .
Distributed Hashing refers to splitting of hash table into several parts needs to be hosted into several severs.

With the above logic the majority of requests would have to redirected to different servers. This would result to cache miss. This introduces the concept of *Consistent Hashing* 

Consistent Hashing depends on distributed hashing scheme which operates on distributes hashing table placed across a ring.
Furthermore, every server is hashed to place it on an angle of the ring.

Every key of object is then directed to server closest in a clockwise directions. This way , if any server is removed from the circle the object key is randomly reassigned to rest of the server.

## Scenarios To use Consistent Hashing ##

a) When we need to elastically scale up and down based on the traffic load 
b) When we have set of cache servers based on the traffic load.

## Benefits Of Consistent Hashing ##

1) Enables elastic load balancing depending upon traffic load.
2) Ease of replication and partitioning of data across servers.
3) Higher availability of systems

## What happens when a server is lost ##

To avoid loss of data when a server is lost we have servers to backup data across the ring. Each server replicates data acting as a backup copy.

## Uneven load of machines due to key spacing ##

To minimize uneven load on servers due to their placement on the ring, we usually have replicas/ virtual nodes of servers placed differently on the ring so that the key distribution becomes more uniform.

## Implementation of Consistent Hashing ##

1. A Hash Table / Hash Ring 
2. Hash Function
3. Server object

## Implemented By ##

1. Apache Cassandra
2. Amazon DynamoDB
3. Memcached
4. Akamai CDN