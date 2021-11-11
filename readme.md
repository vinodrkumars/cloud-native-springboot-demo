#Cloud Native Spring in Action - Book demo Project

Creating PostgresDB on local machine using docker   
````
docker run --name polar-postgres-catalog -e POSTGRESS_USER=admin -e POSTGRESS_PASSWORD=admin \
> -e POSTGRESS_DB=polardb_catalog -p 5432:5432 -d postgres:13

````

````
http POST :8080/books author "Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price 9.90
curl POST :8080/books author "Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price 9.90
curl POST http://localhost:8080/books author="Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price=9.90
curl POST localhost:8080/books author="Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price=9.90
curl -v localhost:8080/books
curl -v -x POST localhost:8080/books author="Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price=9.90
curl -v -X POST localhost:8080/books author="Lyra Silvertongue" title="Northern Lights" isbn=1234567891 price=9.90
curl -v -X POST localhost:8080/books { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -v -X POST localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -v -X --request POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -v -X --request POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -v -X --request POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -V -X POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl -v -X POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl --user "user:password" POST http://localhost:8080/books --data { author:"Lyra Silvertongue", title:"Northern Lights", isbn:1234567891, price:9.90 }
curl --user "user:password" POST http://localhost:8080/books --data { "author":"Lyra Silvertongue", "title":"Northern Lights", "isbn":"1234567891", "price":"9.90" } --header "Content-Type: application/json" 
curl --user "user:password" --request POST http://localhost:8080/books --data { "author":"Lyra Silvertongue", "title":"Northern Lights", "isbn":"1234567891", "price":"9.90" } --header "Content-Type: application/json" 
curl --user "user:password" --request POST http://localhost:8080/books --data { "author":"Lyra Silvertongue", "title":"Northern Lights", "isbn":"1234567891", "price":"9.90" } --header "Content-Type: application/json" 
````