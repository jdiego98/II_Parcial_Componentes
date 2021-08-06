package com.cenfotec.comiteolimpico.services;

import com.cenfotec.comiteolimpico.domain.Atleta;
import com.cenfotec.comiteolimpico.domain.Imc;
import com.cenfotec.comiteolimpico.repositories.AtletaRepository;
import com.cenfotec.comiteolimpico.repositories.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService{

    @Autowired
    AtletaRepository atletaRepo;

    @Autowired
    ImcServiceImpl imcService;

    @Override
    public void save(Atleta atleta) {

        atletaRepo.save(atleta);
        imcService.save(this.calcularIMC(atleta));

    }

    @Override
    public Optional<Atleta> get(Long id) {
        return atletaRepo.findById(id);
    }

    @Override
    public List<Atleta> getAll() {
        return atletaRepo.findAll();
    }

    @Override
    public List<Atleta> find(String nombre) {
        return atletaRepo.findByNombreContaining(nombre);
    }

    @Override
    public void update(Atleta atleta) {
        atletaRepo.saveAndFlush(atleta);
    }

    private Imc calcularIMC(Atleta atleta){
        DecimalFormat df = new DecimalFormat("#.00");
        return  new Imc(new Date(), Math.round((atleta.getPeso()/(atleta.getEstatura()*atleta.getEstatura()))*100d / 100d), atleta);
    }

    @Override
    public List<Atleta> getByTermino(String termino) {

        return  atletaRepo.findByNombreContaining(termino);
    }
}
