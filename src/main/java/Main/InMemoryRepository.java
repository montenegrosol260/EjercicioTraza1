package Main;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T> {//declaramos la clase genérica
   //Estructura de datos que almacena  las instancias asociadas a su clave unica (ID)
    protected Map<Long, T> data = new HashMap<>();
    //Generador de id, se trata de un contador atómico que se incremente automáticamente
    protected AtomicLong idGenerator = new AtomicLong();

    //método que guarda una entidad en la estructura de datos (repositorio)
    public T save (T entity){
        //incrementa el id atómicamente y devuelve un nuevo valor
        long id = idGenerator.incrementAndGet();
        try{
            entity.getClass()
                    //asumimos que la clase de entity tiene un metodo que recibe un long como parámetro
                    .getMethod("setId",Long.class)
                    //invocamos el método buscado
                    .invoke(entity,id);
            //Obtenemos el nombre de la instancia
            String clase = entity.getClass().getName();
            //imprimimos el nombre y el id de la misma
            System.out.println(clase + "id: " + id);
        }catch (Exception e){
            e.printStackTrace();
        }
        //insertamos el par clave-valor en el mapa
        data.put(id, entity);
        return entity;
    }
    //buscamos una entidad a través de su ID
    //usamos optional por si no existe la instancia el compilador
    //no corte el programa
    public Optional<T> findByld(Long id){
        //devuelve la búsqueda en un optional
        return Optional
                //obtiene el id de la instancia, que puede ser null
                .ofNullable(data.get(id));
    }
    //obtiene todas las entidades almacenadas en el repositorio
    public List<T> findAll(){
        //almacenamos en una lista la colección de instancias
        //así al modificar trabajamos con una copia, y no con los valores originales
        return new ArrayList<>(data.values());
    }
    //método para actualizar una entidad existente en el repositorio
    public Optional<T> genericUpdate(Long id, T updateEntity){

    }
}
