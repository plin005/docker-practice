## Project
    backend

## Code Release
 `v0 - release codebase, auto build application and postgresql db`
    
## Enpoint
  db connection health check:
       `http://localhost:8080/diagnostic/dbHealthCheck`

## Postgresql Database 
    postgresql:
        host: 127.0.0.1
        port: 5432
        db_name: test
        username: admin
        password: admin
    
    bd login:  
        psql -U admin -h 127.0.0.1 -p 5432 --password -d test

   
 ## Auto Script 
 
 ##### Auto to setup application with docker
    `./auto/dev
    
    
     
