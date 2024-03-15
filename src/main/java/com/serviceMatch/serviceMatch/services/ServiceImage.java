package com.serviceMatch.serviceMatch.services;

import com.serviceMatch.serviceMatch.entities.Image;
import com.serviceMatch.serviceMatch.exceptions.MyException;
import com.serviceMatch.serviceMatch.repository.ImageRepository;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServiceImage {

    @Autowired
    private ImageRepository imagenRepository;

    @Transactional
    public Image guardarImagen(MultipartFile archivo) throws MyException {

        if (archivo != null) {
            try {
                Image imagen = new Image();
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                return imagenRepository.save(imagen);
            } catch (Exception e) {

            }

        }
        return null;
    }

    @Transactional
    public Image actualizar(MultipartFile archivo, Long idImagen) throws MyException {
        if (archivo != null) {
            try {
                Image imagen = new Image();

                if (imagen != null) {
                    Optional<Image> respuesta = imagenRepository.findById(idImagen);

                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                return imagenRepository.save(imagen);
            } catch (Exception e) {

            }
        }
        return null;
    }
}
