package cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.controller;

import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.entity.Fruta;
import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.service.FrutaService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @PostMapping("/add")
    public ResponseEntity<String>agregarFruta(@RequestBody Fruta fruta){
        frutaService.agregarFruta(fruta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fruta agregada correctamente.");
    }

    @PutMapping("/update")
    public ResponseEntity<String>actualizarFruta(@RequestBody Fruta fruta){
        frutaService.actualizarFruta(fruta);
        return ResponseEntity.status(HttpStatus.OK).body("Fruta actualizada correctamente.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>eliminarFruta(@PathVariable String id){
        frutaService.eliminarFruta(id);
        return ResponseEntity.status(HttpStatus.OK).body("Fruta eliminada correctamente.");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta>buscarFrutaPorId(@PathVariable String id){
        Fruta frutaEncontrada = frutaService.encuentraFrutaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(frutaEncontrada);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFrutas() {
        List<Fruta> frutas = frutaService.imprimeListaDeFrutas();
        if(frutas.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Lista de elemnetos vacía.");
        }
        return ResponseEntity.ok(frutas);
    }

}
