package com.Dhiego.Teste04_Api.repositories;

import com.Dhiego.Teste04_Api.models.Operadorasativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperadorasativaRepository extends JpaRepository<Operadorasativa, Integer> {
    @Query(value = "SELECT * FROM operadorasativas WHERE " +
            "LOWER(Razao_Social) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(Nome_Fantasia) LIKE LOWER(CONCAT('%', :termo, '%')) LIMIT 10",
            nativeQuery = true)
    List<Operadorasativa> buscarPorRazaoSocialOuNomeFantasia(@Param("termo") String termo);
}
