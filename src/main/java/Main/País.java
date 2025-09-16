package Main;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class País {
    private Long id;
    private String nombre;
    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();

    public void addProvincia(Provincia provincia){
        provincias.add(provincia);
        provincia.setPais(this);
    }

//    @Override
//    public String toString() {
//        return "Pais{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                '}';
//    }
}
