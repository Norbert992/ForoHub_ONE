package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.respuesta.DatosRespuesta;
import com.alura.ForoHub.domain.topic.*;
import com.alura.ForoHub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicRepository topicRepository;
    private final TopicService topicoService;

    @Autowired
    public TopicController(TopicRepository topicRepository, TopicService topicoService) {
        this.topicRepository = topicRepository;
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<DatosTopic> registrarTopico(@RequestBody @Valid DatosAgregarTopic datosAgregarTopic, UriComponentsBuilder uriComponentsBuilder) {
        DatosTopic response = topicoService.registrarTopico(datosAgregarTopic);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopic>> listarTopicos(@PageableDefault(size = 3, sort = "fechaCreacion") Pageable paginacion) {
        Page<DatosTopic> page = topicRepository.findAll(paginacion).map(DatosTopic::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopic(@PathVariable Long id) {
        topicoService.eliminarTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosTopic> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopic datosActualizarTopic) {
        DatosTopic response = topicoService.actualizarTopic(id, datosActualizarTopic);
        return ResponseEntity.ok(response);
    }
}
