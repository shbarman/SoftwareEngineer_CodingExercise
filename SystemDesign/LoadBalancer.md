# Load Balancer Introduction #
Critical component of distributed systems. It helps in distributing traffic across nodes of servers, therby maintaining the availiability of the system. Load Balancer keeps routine health checkups of all servers in the server pool. Whichsoever server doesnot respond to health checkups it stops sending traffic to the server.

Pros:
1. Optimization of resources
2. Availability of network and responsiveness.
3. Less Downtime and higher throughput (rate of processing)
4. Fewer Stressed components

![LoadBalancer](/SystemDesign/images/lb.JPG)


## Placement of Load Balancers ##

1. Between User and the web server
2. Between Web server and and internal platform layer like application server or cache
3. Between Internal Platform Layer and database

This is classified into:

a) Network Load Balancing : Handles TCP/UDP traffic, it leverages network layer information to decide where should the traffic be redirected to. Layer 4

b) HTTP(s) Load Balancing : Layer 7, it directs traffic on basis of information with HTTP address

c) Internal Load Balancing : Balancing internal infrastructure.

## Algorithms of Load Balancers ##


1. Round Robin : The load is cycled to sort request. The load is sent to the first available node and then to the next server. On reachimg the end of the list of the servers it sends it to the first server again.

2. Round Robin with weighted servers : Each server is assigned weights on its capacity to process and server with higher weigths recieve traffic before than the lesser weight ones.


3. Least Connection method : The servers with least active connections recieve the traffic first. These are helpful in unevenly distributes servers.


4. Least Bandwidth method : The servers serving least amount of traffic calculated in Mbps is selected first


5. Least Response Time method : Selection of server is based on fewer active connection and having least response time.


6. IP Hash : Server is determined on basis of client's ip address.

### Note :  Consistent Hashing ?? 

Though Round robin distributes load evenly , HAProxy taked hash of part of request to determine the available server.
For Scenarios where we need to add servers we would have to consistently keep changing the hashing of servers 
 
 Hash Function : Hash(client ip address) -> result % number of servers to determine which server the load is directed to.


With the above logic the majority of requests would have to redirected to different servers. This introduces the concept of *Consistent Hashing*

[**Consistent Hashing**](/SystemDesign/ConsistentHashing.md) Each server is assigned multiple hash values and each request recieved is directed to the nearest value

*For, conditions where server is stable and traffic of LB is at random Round Robin is used. Whereas, distributed systems which needs to scale out and requests would have to map to same server. Consistent Hashing helps in achieving well - distributed uniformity.*

## Types Of Load Balancer ##

1. Hardware Load Balancer : Physical, on premises hardware which distributes network traffic. It balances large volume of traffic but are expensive.

2. Software Load Balancer : Hybrid approach with open source and more affordable solutions.

3. Virtual Load Balancer :


# References: #

https://medium.com/vimeo-engineering-blog/improving-load-balancing-with-a-new-consistent-hashing-algorithm-9f1bd75709ed

http://stackoverflow.com/questions/58361938/why-do-we-need-consistent-hashing-when-round-robin-can-distribute-the-traffic-ev#:~:text=So%20consistent%20hashing%20lets%20us,LB%20traffic%20is%20at%20random.&text=Consistent%20hashing%20can%20achieve%20well-distributed%20uniformity.,-Hope%20this%20makes


