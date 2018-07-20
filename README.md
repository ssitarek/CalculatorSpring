Calculator - web application with few endpoints that realizes the basic math functions 
like add, subtract, multiply, divide and power.

Calculator is working on localhost port 8080 (http://127.0.0.1:8080/)

Query example for particular functions:

- add function:
```
http://127.0.0.1:8080/calc/add?a=5.0&b=2.0
```

- subtract function:
```
http://127.0.0.1:8080/calc/subtract?a=5.0&b=2.0
```
- multiply function:
```
http://127.0.0.1:8080/calc/multiply?a=5.0&b=2.0
```
- power function:
```
http://127.0.0.1:8080/calc/power?a=5.0&b=2.0
http://127.0.0.1:8080/calc/power?a=-1.0&b=0.5
```
- divide function:
```
http://127.0.0.1:8080/calc/divide?a=5.0&b=2.0
http://127.0.0.1:8080/calc/divide?a=5.0&b=0.0
```
In general it is not required to check if (base>0) for sqrt operation (power(-1,0.5) 
due to the fact that there are exception handling (see: https://en.wikipedia.org/wiki/IEEE_754) 
but the endpoint with manual checking has been also prepared:

- divideWithChecking
```
http://127.0.0.1:8080/calc/divideWithChecking?a=5.0&b=2.0
http://127.0.0.1:8080/calc/divideWithChecking?a=5.0&b=0.0
```