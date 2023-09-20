package cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.controller;

import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.entity.Fruta;
import cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03.model.repository.FrutaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FrutaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    FrutaRepository frutaRepository;

    @AfterEach
    public void Delete(){
        frutaRepository.deleteAll();
    }

    @Test
    public void testAgregarFruta() throws Exception {
        Fruta fruta = Fruta.builder()
                .nombre("Mango")
                .cantidadKg(3)
                .build();

        mockMvc.perform(post("/fruta/add")
                        .content(objectMapper.writeValueAsBytes(fruta))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("Fruta agregada correctamente."));
    }

    @Test
    public void testActualizarFruta() throws Exception {
      Fruta fruta= Fruta.builder()
                .id("1")
                .nombre("Melón")
                .cantidadKg(3)
                .build();

      frutaRepository.save(fruta);
      fruta.setCantidadKg(3);

        mockMvc.perform(put("/fruta/update")
                        .content(objectMapper.writeValueAsBytes(fruta))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Fruta actualizada correctamente."));

        Fruta frutaActualizada = frutaRepository.findById("1").orElse(null);

        assertNotNull(frutaActualizada);
        assertNotEquals(2, frutaActualizada.getCantidadKg());
        assertEquals(3,frutaActualizada.getCantidadKg());
    }

    @Test
    public void testEliminarFruta() throws Exception {
        frutaRepository.save(Fruta.builder()
                .id("1")
                .nombre("Arándanos")
                .cantidadKg(1)
                .build());

        mockMvc.perform(delete("/fruta/delete/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Fruta eliminada correctamente."));
    }

    @Test
    public void testBuscarFrutaPorId() throws Exception {
        frutaRepository.save(Fruta.builder()
                .id("1")
                .nombre("Melocotón")
                .cantidadKg(2)
                .build());

        mockMvc.perform(get("/fruta/getOne/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    public void testGetAllFrutas() throws Exception {
        mockMvc.perform(get("/fruta/getAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}