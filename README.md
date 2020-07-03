# MULTITHREADED NATIVE JAVA HTTP SERVER WITH PERFORMANCE TEST


This basic application is nothing else, jut playing around native Java HttpServer capabilities with threads and testing performance.


## Goal 

- Implementing com.sun.net.httpserver.HttpHandler for handling HTTP requests, then playing with different fix-sized thread pools.

- Testing the performance with different thread pool settings.

## Tech Stack
- Java  11
- Apache JMeter (5.3)
- Maven

## JMeter setup

- no ramp-up period
- 200 concurrentthreads

## Test Environment

Processor 2.9 GHz Intel Core i7
OS: MacOS Mojave 10.14.6 (18G5033)


## Result

![single-threaded-result](/performance-test-result/single-threaded-result.png)
![double-threaded-result](/performance-test-result/double-threaded-result.png)
![4-threaded-result](/performance-test-result/4-threaded-result.png)
![5-threaded-result](/performance-test-result/5-threaded-result.png)
![6-threaded-result](/performance-test-result/6-threaded-result.png)


## Used resources
- [random csv generator for searching word](https://onlinerandomtools.com/generate-random-csv)
- [jmeter](https://jmeter.apache.org/)
- [book text](https://www.gutenberg.org/ebooks/1342)