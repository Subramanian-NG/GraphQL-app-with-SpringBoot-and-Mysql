Simple GraphQL app with spring boot framework and mysql database
- GraphQL endpoints(Queries and Mutations) are built using GraphQL schema and EmployeeGraphQLController acts as query resolver.
- CRUD operations on Employee table can be performed using GraphQL endpoints.
- Employee database operations are implemented by default with Springboot JPA repository (EmployeeRepository)
- The mysql database table is mapped to Java Entity class (Employee) using Object Relational Mapping(ORM)
- Springboot GraphQL integration take care of the mapping between Java class and GraphQL schema datatypes.
