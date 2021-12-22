#Cloud Native Spring in Action - Book demo Project
This project includes examples implemented following 
    Manning book (Cloud Native in Action)
    Spring Netfix Hystrix circuit breaker


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

References for Circuit Breaker 
https://spring.io/projects/spring-cloud-circuitbreaker#samples
https://github.com/spring-cloud-samples/spring-cloud-circuitbreaker-demo/
    1. Added CircuitBreakerFactory bean in SpringBootApplication class
    2. Added circuitBreaker example method in Service class (Book Service)
    3. Added spring cloud( cloud-starter-config, cloud-dependencies, bootstrap-cloud ), hystrix dependencies in pom.xml file

### Updated Junit 5 dependency in POM.xml

### Following is REST URL for accessing hierarchical resource access /books/1/sellar/2
@RequestMapping(value="{id}/seller/{sellerId}", method=RequestMethod.PUT)
public String getBookSeller(@PathVariable String id, @PathVariable String sellerId){
return "seller of this book :" + id + " is :" + sellerId;
}


### Ended in Jpa nested long output while using oneToMany ManyToOne mapping on book and author fields
### solved by below suggestion from stackoverflow 

```
https://stackoverflow.com/questions/16577907/hibernate-onetomany-relationship-causes-infinite-loop-or-empty-entries-in-json

Solution:

Use

@JsonManagedReference annotation for the first objects instantiated

@JsonBackReference annotation for the second objects instantiated

Movie.java

@JsonManagedReference
@OneToMany(mappedBy = "movie", targetEntity = Clip.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private Set<Clip> clips = new HashSet<Clip>();
Clip.java

@JsonBackReference
@ManyToOne
@JoinColumn(name="movie_id")
private Movie movie;
```

