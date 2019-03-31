Sample Spring-GraphQL application

user with ID 1-3 are pre-filled

### GraphQL Schema
```
type User {
	login: String!,
	id: ID!,
	name: String
}

type Query {
	users(first:ID, last: ID): [User]
	user(id: ID!): User
	userzero: User
}

type Mutation {
	createUser(login: String!, name: String!): User
}
```


### Sample Clients
GraphiQL: http://localhost:8080/graphiql


##### Sample Query
**userone: User**

```
# GraphiQL

query {
  userone {
    id
    name
  }
}
```

```
curl http://localhost:8080/graphql \
-X POST \
-H 'Content-Type: application/json' \
-d '{
"query":"query { userone {id, name} }"
}'
```

**user(id: ID!): User**
```
# GraphiQL

query {
  user(id:3) {
    name
  }
}
```

```
# GraphiQL

{
  query: user(id: 3) {
    name
    login
  }
}
```

```
# GraphiQL

query user($n: ID!) {
  user(id: $n) {
    name
  }
}

# QUERY VARIABLE
{
  "n":3
}
```

```
curl http://localhost:8080/graphql \
-X POST \
-H 'Content-Type: application/json' \
-d '{
"query":"query{user(id:3) {name}}"
}'
```

**users(first:ID, last: ID): [User]**
```
GraphiQL

query {
  users(first:1, last:3){
    id
    name
  }
}
```

```
curl http://localhost:8080/graphql \
-X POST \
-H 'Content-Type: application/json' \
-d '{
"query":"{users(first:0,last:0) {id,name}}"
}' 

```

##### Sample Mutation

**createUser(login: String!, name: String!): Use**
```
mutation {
  createUser(login:"testLogin", name: "testName") {
    id
    login
    name
  }
}
```

```
curl http://localhost:8080/graphql \
-X POST \
-H 'Content-Type: application/json' \
-d '{
"query": "mutation{createUser(login:\"testLogin\", name: \"testName\") {id,login,name}}"
}'
```
