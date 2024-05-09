# Bank System Spring Boot Console Application

This is a simple console application developed in Java using Spring Boot for managing a bank system. It allows users to:
-create banks,
-accounts,
-perform transactions,
-withdrawals, 
-deposits,
-view account transactions and more.

## Getting Started
To run this application, you need to have the following software installed on your machine:

- Java Development Kit (JDK)
- Maven
- Git

### Installation
1. Clone the repository to your local machine:
    ```bash
   git clone https://github.com/example/BankSystemSpringBoot.git](https://github.com/RinesaBislimi/BankSystem-.git
   ```
 
2. Navigate to the project directory:

   ```bash
   cd BankSystemSpringBoot
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```
## Usage
1. Run the application
2. Follow the instructions provided in the console to interact with the bank system
   
## Features
![Screenshot 2024-05-09 184228](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/7a483c4c-e436-4195-8dac-19306d97563f)

1. Create bank feature:
![Screenshot 2024-05-09 185428](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/065ba1b2-0f75-4dcc-a75a-4ebc05eee2ba)
2. Create account feature:
![Screenshot 2024-05-09 184326](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/c8500883-a792-48cf-8f6d-41010e05ec5a)
3.Perform transaction
![Screenshot 2024-05-09 184500](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/e499cb11-1e64-4b0c-911e-0ef6850eed9e)
4.See list of bank accounts
![Screenshot 2024-05-09 184513](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/a982f77f-fbf7-4503-aeb2-9ee7dbf9621c)
5.View account transactions when account does not exist
![Screenshot 2024-05-09 184532](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/4fd386bd-7ca2-48bb-9753-9814f178e608)


## Bonus points for designing a Spring Boot RESTful web service
### Account Endpoint
The /account endpoint allows clients to create new accounts within the bank system. It accepts a POST request with a request body in the form of an AccountDto, which contains details such as the account name and initial balance. Upon successful creation of an account, the endpoint returns a response with HTTP status code 201 (Created), along with the details of the newly created account including its name and balance. If any error occurs during the account creation process, the endpoint returns an error response with HTTP status code 500 (Internal Server Error) and an appropriate error message.
### Using Postman for testing RESTful APIs
In Postman, you can test the /account endpoint by sending a POST request to the endpoint URL : http://localhost:8080/api/account  with a JSON body containing the necessary details for creating a new account, such as the account name and initial balance. 
![Screenshot 2024-05-09 183656](https://github.com/RinesaBislimi/BankSystem-/assets/118773246/45c46c25-70b6-44d8-9312-7e33618e62ac)

    
