package com.Dhiego.Teste04_Api.controllers;

import com.Dhiego.Teste04_Api.models.OperadorasAtivasDTO;
import com.Dhiego.Teste04_Api.service.BuscaOperadorasService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@CrossOrigin
public class BuscarOperadoraController {

    private BuscaOperadorasService boSerivce;

    public BuscarOperadoraController(BuscaOperadorasService boSerivce) {
        this.boSerivce = boSerivce;
    }

    @GetMapping("/mais-relevantes-operadoras/{termo}")
    public ResponseEntity<List<OperadorasAtivasDTO>> buscarOperadorasMaisRelevantes(@PathVariable String termo) {


        if (termo == null || termo.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<OperadorasAtivasDTO> resultado = boSerivce.buscarOperadorasMaisRelevante(termo);

        if (resultado == null || resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }
}
