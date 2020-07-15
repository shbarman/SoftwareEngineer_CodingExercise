# Introduction #
Component to store data for faster retrieval in future.
*Cache hit* is referred to when the required data is found in cache.
*Cache miss* occurs when the requested data is not available.

It works on principle of local reference. It can be used in almost every layer.

## Types of Cache ##

1. In Memory cache -- enables local storage on request layer node but chances of cache miss increases when distributed systems comes into picture.

2. In Memory Distribute Cache -- nodes built externally to an application. Deployed in cluster of multiple nodes but in single logical view. Cache can be divided using consistent hashing, to find the request node consisting data.

3. Database Cache -- Includes level of caching in default configs requiring optimization

4. CDN : Content Delivrey Network -- This sits between original servers and clients. Theses are mostly for static medium like HTML, CSS, JavaScript etc. Works mostly for geo distributed servers where building replicas of infrastructure is cost effective.

## Patterns of Data Caching ##

1. Database Query Cache: On querying database the dataset is stored in the cache.The hash of result dataset called the cache key. Upon querying database first the existence of this cache key is determined. If present the result dataset is retrieved otherwise, queried from the database and stored in cache for further queries.
Cons:
a) Deleting of result with complex queries is difficult.
b) If on data changes in database the whole table cell in cache needs to updated as well.

2. Object Cache: Storing of data as objects. Example User data, web sessions.

## Cache Update Strategies ##

1. **Cache Aside**: also known as lazy loading. Mostly used in read- heavy workloads. Application first checks data in cache if not found the cache is queried from database and then copied into cache for future reads.
This mode reduces cache miss because even after cache failure the application retrieves data, however, causing performance lag due to the three trips. Every new node would result in cache miss and considerable amount of response lag.
Memcached is mostly used in this manner.

![CacheAside](/SystemDesign/images/cache1.JPG)

2. **Read Through**: Similar lazy loading feature. A stand alone cache provider works best for read heavy systems. 

![ReadThrough](/SystemDesign/images/cache2.JPG)

3. **Write Through**: The cache layer sits between the database and the user. The cache is used as the main data provider for the application, every data request recieved is first written into the cache and then into the data store. Thus, every data is synchronously written into the data store. This process is considerably slow in comparison to cache aside. One advantage of this type of cache update strategy is that the data is not stale. 
When new node is introduced, it will not  have entries until it is updated in the database.

![WriteThrough](/SystemDesign/images/cache3.JPG)


4. **Write Behind**: The data from cache is asynchronously written into database at a time interval event loop.However, in case of cache node failure the data might be lost before it is written into the database.

![WriteBehind](/SystemDesign/images/cache4.JPG)


## Cache Eviction Policy ##

1. LRU : Least Recently Used
2. LFU : Least Frequently Used 
3. MRU : Most Recently Used 
4. FIFO : First In First Out
5. LIFO : Last In First Out
6. RR : Random Replacement

