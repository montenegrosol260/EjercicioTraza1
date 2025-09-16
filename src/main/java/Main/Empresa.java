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
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;
    private Set<Sucursal> sucursales = new HashSet<>();

    public void addSucursal (Sucursal sucursal){
        sucursales.add(sucursal);
        sucursal.setEmpresa(this);
    }
}
