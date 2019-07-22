Project description:
- This is a Java Spring Boot project taken as a home assignment 
while being in a Wallapop backender application process. It uses 
Maven as the dependency Manager. The project is based on moving a 
Robot around a 2D field.

    The project has an API-Service-Repository architecture. As an example of design patterns, Factory and Strategy are used on the robot direction.
    
Problems encountered:
- Indecision to separate the files as package-per-feature or package-per-layer. At the end I decided package-per-layer because is more clear on projects of this small size. In case of adding extra features we could study the possibility of separate the files package-per-feature, because this way we can increase the cohesion and the autonomy of related files on bigger projects.

- First of all thought about implementing the field using a matrix representing field obstacles, but using a HashMap to store obstacles is more memory efficient. 

Things to improve:
- I´ve created a small custom repository that reads and writes on a file, to have persistance and at the same time don't need to set up Hibernate and MySQL. A good next step in case we want to extend this project could be adding an ORM like Hibernate as the persistance framework.
 
- For this exercise I´m assuming the initial configuration POST body will be correct, but a next step will be adding validation.

- Adding token authorization provided on the requests headers to protect endpoints from external users.

- Return a DTO instead of the whole entity from the repository. Then we´ll manage to:
    - Just fetch required data from the database, avoiding possible extra queries.
    - Hide unnecessary entity attributes for the repository user, we´ll only send the needed values.
    
