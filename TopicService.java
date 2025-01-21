package com.alura.ForoHub.service;

import com.alura.ForoHub.domain.topic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public DatosTopic registrarTopico(DatosAgregarTopic datosAgregarTopic) {
        // Valida si el topico ya existe
        if (topicRepository.existsByTitulo(datosAgregarTopic.titulo()) && topicRepository.existsByMensaje(datosAgregarTopic.mensaje())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este tópico ya existe");
        }
        Topico topico = new Topico(datosAgregarTopic);
        topicRepository.save(topico);
        return new DatosTopic(topico);
    }

    public void eliminarTopic(Long id) {
        Topico topico = TopicExists(id);
        topicRepository.delete(topico);
    }

    public Topico TopicExists(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Este tópico no existe"));
    }

    public DatosTopic actualizarTopic(Long id, DatosActualizarTopic datosActualizarTopic) {
        Topico topico = TopicExists(id);
        topico.setTitulo(datosActualizarTopic.titulo());
        topico.setAutor(datosActualizarTopic.autor());
        topico.setMensaje(datosActualizarTopic.mensaje());
        topico.setCurso(datosActualizarTopic.curso());

        if ("CERRADO".equalsIgnoreCase(datosActualizarTopic.status())) {
            topico.setStatus("CERRADO");
        }

        topicRepository.save(topico);
        return new DatosTopic(topico);
    }
}
