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


