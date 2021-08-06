package com.cenfotec.comiteolimpico.services;

import com.cenfotec.comiteolimpico.domain.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaService {

    public void save(Atleta atleta);
    public Optional<Atleta> get(Long id);
    public List<Atleta> getAll();
    public List<Atleta> find(String nombre);
    public void update(Atleta atleta);
    public List<Atleta> getByTermino(String termino);
}
