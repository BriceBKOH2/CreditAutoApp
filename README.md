First sprint :
1 Loan simulation
2 Creating client account
3 Creating loan contract
4 Linking contract with client account

Second Sprint :
1 Finish Sprint 1 leftover stories
2 Search client with given parameters (name, surname, accountNumber, ...)

Third Sprint :
1 modify / close contract
2 modify / close client account
3 view and modify api parameters
4 logging with different users type

Forth Sprint :
1 view statistics (print?)
2 view and modify rent rights with a contract id
3 check code visibility and javadoc / comment
4 unit testing


 -- LogBook --
 
Sprint 1 : 1day 1/2 spend fixing software and configuration issue
last 1/2 day spent on creating simulation page in angular and all models and database tables. Added client, contract and rate DAO, service + rate controller. Front part can access all rates from database table via back api url + print result on simul page.

Sprint 2 :
Finishing Sprint 1 : Access specific rate with correct parameters that is calculated in the back part. Client and Contract controller created, Front can send a post request with a Client object
Creating Client with specific request with Postman to feed the back and save it in database is working, but not linked to Front.
Done a presentation of work done and what's left to Product Owner

Sprint 3 :
Front creates a Contract object with parameters from the form present in the simul page, form get its vehicule category from database
