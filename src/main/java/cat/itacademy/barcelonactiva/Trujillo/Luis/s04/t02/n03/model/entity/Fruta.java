package cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document (value = "Frutas")
public class Fruta {

    @MongoId
    private String id;
    private String nombre;
    private int cantidadKg;
}
