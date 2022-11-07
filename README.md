# Project assignment 

Design a web app ( backend only) using the spring boot application and H2 database. 


## API Reference

#### Creates a new user

```http
  POST /user 
```

| returns     | Description                |
| :------- | :------------------------- |
| `User`   | Creates a new user |

####  Return user by id

```http
  GET  /user/{id} 
```

| Parameter | Type     |returns| Description                       |
| :-------- | :------- |:------| :-------------------------------- |
| `id`      | `Long` |`User`| Return user by id |

####  Returns list of users
```http
  GET  /users 
```

| returns | Description                |
| :-------| :------------------------- |
| `List<User>`  | Returns list of users |

####  Create an email in DB
```http
  POST /email 
```

| returns | Description                |
| :-------| :------------------------- |
| `Email`  | Create an email in DB |

####  Returns number of email send by a user

```http
  GET  /emails/{useID} 
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | Returns number of email send by a user |




## Running Tests

To run tests, go to UserControlerIntegrationTest, UserControlerUnitTest



