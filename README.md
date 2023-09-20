# SpringBoot-CrudMongo
ApiRest Crud @MongoDB 

Estructura de la aplicación
![Proyevto](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/0a0fa6d1-81b8-4fc2-884f-aabfe1922ecb)

Tenemos una entidad llamada "Fruta" que tiene las siguientes propiedades:

- int id
- String nombre
- int cantidadKilos

Utilizando la especificación JPA, deberás persistir esta entidad en una base de datos H2 siguiendo el patrón MVC. Para hacer esto, dependiendo del paquete principal, crearás una estructura de paquetes donde ubicarás las clases que necesitas:

- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.entity
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository

La clase ubicada en el paquete "controllers" (por ejemplo, FruitaController) deberá ser capaz de responder a las siguientes solicitudes para actualizar y consultar información:

- http://localhost:8080/fruta/add
![ADD](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/0438e9af-7e19-424b-b571-6bb24c9ff450)

- http://localhost:8080/fruta/update
![Update](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/d9d30918-0c73-44bd-b3ed-c4651b2e93dd)

- http://localhost:8080/fruta/delete/{id}
  ![Delete](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/bfa71e61-1579-4836-ae52-7481a3201e42)

- http://localhost:8080/fruta/getOne/{id
  ![GetOne](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/038e2af4-6132-44b7-97eb-33a9351a7eaf)

- http://localhost:8080/fruta/getAll
  ![GetAll](https://github.com/Luiso-o/SpringBoot-CrudMongo/assets/128043647/70d4d727-776b-4d4f-9398-7b89ae14d75b)

