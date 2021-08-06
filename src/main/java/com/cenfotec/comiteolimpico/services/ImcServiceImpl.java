package com.cenfotec.comiteolimpico.services;

import com.cenfotec.comiteolimpico.domain.Atleta;
import com.cenfotec.comiteolimpico.domain.Imc;
import com.cenfotec.comiteolimpico.repositories.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImcServiceImpl implements ImcService{

    @Autowired
    ImcRepository imcRepository;

    @Override
    public void save(Imc imc) {
        imcRepository.save(imc);
    }

    @Override
    public List<Imc> getHistorico(Long idAtleta) {

        List<Imc> historico = new ArrayList<Imc>();

        for(Imc imc: imcRepository.findAll()){
            if(imc.getAtleta().getId() == idAtleta){
                historico.add(imc);
            }
        }

        return historico;
    }
}
