#Cloud Native Spring in Action - Book demo Project

Creating PostgresDB on local machine using docker   
````
docker run --name polar-postgres-catalog -e POSTGRESS_USER=admin -e POSTGRESS_PASSWORD=admin \
> -e POSTGRESS_DB=polardb_catalog -p 5432:5432 -d postgres:13