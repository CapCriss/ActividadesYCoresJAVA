package com.curso.springboot.vs.spring_vs.controladores;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.vs.spring_vs.modelos.messageDto;

@RestController
public class mensajeControlador {
    @GetMapping("/api/mensaje")
	public messageDto mensaje(){

		return  new  messageDto(LocalDateTime.now(), "HOLA DESDE VS CODE x2");
	}


}
