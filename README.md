# InMemoryRepository - Persistencia en Memoria con Java
## Descripción
`InMemoryRepository` es una implementación ligera y genérica de un repositorio en memoria desarrollado en Java. Este proyecto utiliza un `HashMap` para almacenar objetos y un `AtomicLong` para generar identificadores únicos, proporcionando una solución simple para la persistencia temporal de datos en aplicaciones Java. 
La clase soporta operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y permite buscar objetos por campos específicos mediante el uso de reflexión, lo que la hace flexible para trabajar con diferentes tipos de objetos que implementen los métodos `setId` y getters correspondientes.

