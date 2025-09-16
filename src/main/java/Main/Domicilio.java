package Main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;

//    @Override
//    public String toString() {
//        return "Domicilio{" +
//                "id=" + id +
//                ", calle='" + calle + '\'' +
//                ", numero='" + numero + '\'' +
//                ", codigo postal='" + cp + '\'' +
//                '}';
//    }
}
