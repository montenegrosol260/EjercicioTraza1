package Main;

import java.time.LocalTime;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        País Argentina = País.builder()
                         .nombre("Argentina")
                         .build();
        Provincia bsAs = Provincia.builder()
                                  .nombre("Buenos Aires")
                                  .build();
        //agregamos al hashset la provincia
        //el metodo add establece la relac bidireccional, por eso no la establec en el build
        Argentina.addProvincia(bsAs);
        Localidad CABA = Localidad.builder()
                                  .nombre("CABA")
                                  .build();
        bsAs.addLocalidad(CABA);
        Domicilio domic1 = Domicilio.builder()
                                    .calle("Sobremonte")
                                    .cp(5500)
                                    .numero(987)
                                    .build();
        CABA.addDomicilios(domic1);
        Localidad Laplata = Localidad.builder()
                                     .nombre("La Plata")
                                     .build();
        bsAs.addLocalidad(Laplata);
        Domicilio domic2 = Domicilio.builder()
                                    .calle("Rodriguez")
                                    .cp(5577)
                                    .numero(345)
                                    .build();
        Laplata.addDomicilios(domic2);
        Provincia Cordoba = Provincia.builder()
                                     .nombre("Córdoba")
                                     .build();
        Argentina.addProvincia(Cordoba);
        Localidad CordobaCap = Localidad.builder()
                .nombre("Córdoba Capital")
                .build();
        Cordoba.addLocalidad(CordobaCap);
        Domicilio domic3 = Domicilio.builder()
                                    .calle("Emilio Jofré")
                                    .cp(5050)
                                    .numero(404)
                                    .build();
        CordobaCap.addDomicilios(domic3);
        Localidad VCP = Localidad.builder()
                                 .nombre("Villa Carlos Paz")
                                 .build();
        Cordoba.addLocalidad(VCP);
        Domicilio domic4 = Domicilio.builder()
                                    .calle("Colon")
                                    .cp(4430)
                                    .numero(547)
                                    .build();
        VCP.addDomicilios(domic4);
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domic1)
                .build();
        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domic2)
                .build();
        Sucursal sucursal3 = Sucursal.builder()
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domic3)
                .build();
        Sucursal sucursal4 = Sucursal.builder()
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domic4)
                .build();
        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .cuit(438975342)
                .razonSocial("S.L.")
                .logo("LOGO1")
                .build();
        empresa1.addSucursal(sucursal1);
        empresa1.addSucursal(sucursal2);
        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .cuit(578380248)
                .razonSocial("S.A")
                .logo("LOGO 2")
                .build();

    }
}