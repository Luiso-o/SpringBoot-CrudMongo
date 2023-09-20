package cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.service;

import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.excepciones.IdNotFountException;
import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.entity.Fruta;
import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.repository.FrutaRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void agregarFruta(Fruta fruta) {
        fruta.setId(generarNuevoId());
        frutaRepository.save(fruta);
    }

    public void actualizarFruta(Fruta fruta){
     Fruta frutaVerificada = buscarIdFruta(fruta.getId());
     frutaVerificada.setNombre(fruta.getNombre());
     frutaVerificada.setCantidadKg(fruta.getCantidadKg());
        frutaRepository.save(frutaVerificada);
    }

    public void eliminarFruta(String id) {
       Fruta frutaAEliminar = buscarIdFruta(id);
       frutaRepository.delete(frutaAEliminar);
    }

    public Fruta encuentraFrutaPorId(String id) {
        return buscarIdFruta(id);
    }

    public List<Fruta> imprimeListaDeFrutas() {
        return frutaRepository.findAll();
    }

    private Fruta buscarIdFruta(String id) {
       return frutaRepository.findById(id)
               .orElseThrow(() -> new IdNotFountException("Error, no se encontró fruta con el ID " + id));
    }

    private String generarNuevoId() {
        // Crea una consulta que ordene los documentos por ID de forma descendente
        Query query = new Query().with(Sort.by(Sort.Order.desc("_id"))).limit(1);

        // Ejecuta la consulta para obtener el primer documento (el último por ID)
        Fruta ultimaFruta = mongoTemplate.findOne(query, Fruta.class);

        if (ultimaFruta != null) {
            // Si se encuentra una fruta, devuelve el ID más uno como un String
            String ultimoId = ultimaFruta.getId();
            int siguienteId = Integer.parseInt(ultimoId) + 1;
            return String.valueOf(siguienteId);
        } else {
            // Si no se encuentra ninguna fruta, devuelve "1" como un String
            return "1";
        }
    }


}
