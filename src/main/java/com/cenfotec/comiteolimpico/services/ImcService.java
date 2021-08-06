package com.cenfotec.comiteolimpico.services;

import com.cenfotec.comiteolimpico.domain.Atleta;
import com.cenfotec.comiteolimpico.domain.Imc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImcService {

    public void save(Imc imc);
    public List<Imc> getHistorico(Long idAtleta);
}


