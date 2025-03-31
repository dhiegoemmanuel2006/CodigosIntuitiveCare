package com.Dhiego.Teste04_Api.service;

import com.Dhiego.Teste04_Api.models.OperadorasAtivasDTO;
import com.Dhiego.Teste04_Api.models.Operadorasativa;
import com.Dhiego.Teste04_Api.repositories.OperadorasativaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscaOperadorasService {
    private OperadorasativaRepository oaRepository;

    public BuscaOperadorasService(OperadorasativaRepository oaRepository) {
        this.oaRepository = oaRepository;
    }


    public List<OperadorasAtivasDTO> buscarOperadorasMaisRelevante(String termo) {
        List<Operadorasativa> result =  oaRepository.buscarPorRazaoSocialOuNomeFantasia(termo);

        List<OperadorasAtivasDTO> dtos = new ArrayList<>();

        for (Operadorasativa o : result) {
            dtos.add(new OperadorasAtivasDTO(o));
        }

        return dtos;
    }
}
