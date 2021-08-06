package com.cenfotec.comiteolimpico.repositories;

import com.cenfotec.comiteolimpico.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    public List<Atleta> findByNombreContaining(String word);
}
