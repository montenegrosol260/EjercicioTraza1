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
public class Localidad {
    private Long id;
    private String nombre;
    private Set<Domicilio> domicilios = new HashSet<>();
    private Provincia provincia;

    public void addDomicilios (Domicilio domicilio){
        domicilios.add(domicilio);
        domicilio.setLocalidad(this);
    }
}
