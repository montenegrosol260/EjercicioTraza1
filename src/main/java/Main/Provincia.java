package Main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Provincia {
    private Long id;
    private String nombre;
    private Set<Localidad> localidades = new HashSet<>();
    private País pais;

    public void addLocalidad(Localidad localidad){
        localidades.add(localidad);
        localidad.setProvincia(this);
    }
}
