package Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public Optional<T> findById(Long id){
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
    public Optional<T> genericUpdate(Long id, T updatedEntity){
        //verificamos la existencia del ID en el repo
        //si resulta así, devuelve true
        if (!data.containsKey((id))){
            //si no existe, devuelve un Optional vacio
            return Optional.empty();
        }
        try {
            //usamos reflexion para obtener el metodo setId de la instancia
            //obtenemos el objeto
            //es necesario hacerlo en tpo de ejecucion ya que el compilador no conoce el tipo de antemano
            Method setIdMethod = updatedEntity.getClass()
                    //buscamos el método
                    .getMethod("setId", Long.class);
            //ejecuta o invoca el metodo setId obtenido de la instancia
            //pasandole el id cmo argumento del set
            //es decir la logica implica que yo le paso una instancia con cambio de datos
            //y fuerzo a que esta tenga el mismo id que la que está desactualiz
            setIdMethod.invoke(updatedEntity, id);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException("Error al actualizar la entidad", e);
        }

        //sobrescribimos la colección que ya tiene el id correcto
        data.put(id, updatedEntity);

        return Optional.of(updatedEntity);
    }
    //método que elimina una entidad del repo
    public Optional<T> genericDelete(Long id){
        if (!data.containsKey((id))){
            //si no existe, devuelve un Optional vacio
            return Optional.empty();
        }
        //protegemos con un optional el caso de una referencia colgada
        return Optional.ofNullable(data.remove(id));
    }

    public List<T> genericFindByField(String fieldName, Object value) throws InvocationTargetException, IllegalAccessException {
        //lista que guarda las entidades que coincidan con el criterio de búsqueda
        List<T> results = new ArrayList<>();
        //iteramos sobre todas las entidades del repo
        for (T entity : data.values()){
            try {
                //obtenemos el método getter
                Method getFieldMethod = entity.getClass().getMethod("get" + capitalize(fieldName));
                //invocamos el método getter
                Object fieldValue = getFieldMethod.invoke(entity);
                //verificamos si el valor del campo coincide con el buscado
                if (fieldValue != null && fieldValue.equals(value)){
                    results.add(entity);
                }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return results;
    }
    private String capitalize(String str){
        if (str == null || str.isEmpty()){
            return str;
        }
        //tenemos begin index y endIndex -1 por eso para quedarnos en la posic inicial
        //usamos 1-1=0
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
