package com.cenfotec.comiteolimpico.controller;

import com.cenfotec.comiteolimpico.domain.Atleta;
import com.cenfotec.comiteolimpico.domain.Parametro;
import com.cenfotec.comiteolimpico.services.AtletaService;
import com.cenfotec.comiteolimpico.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AtletaController {

    @Autowired
    AtletaService atletaService;

    @Autowired
    ImcService imcService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertar";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarAction(Atleta atleta, BindingResult result, Model model) {
        atletaService.save(atleta);
        return "index";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("atletas",atletaService.getAll());
        return "listar";
    }

    @RequestMapping( value = "/buscar",  method = RequestMethod.GET)
    public String buscar(Model model) {
        model.addAttribute("parametro", new Parametro() );
        return "buscar";
    }

    @RequestMapping(value = "/buscar",  method = RequestMethod.POST)
    public String buscar(@ModelAttribute("parametro") Parametro parametro, BindingResult result, Model model) {

        if(parametro.getTermino() == null){
            model.addAttribute("atletas", this.atletaService.getAll());
        }else{
            model.addAttribute("atletas", this.atletaService.getByTermino(parametro.getTermino()));
        }
        return "buscar";
    }

//    @RequestMapping(value = "/buscar",  method = RequestMethod.POST)
//    public String buscarAction(String termino, BindingResult result, Model model) {
//
//        if(termino == null){
//            model.addAttribute("atletas", this.atletaService.getAll());
//        }else{
//            model.addAttribute("atletas", this.atletaService.getByTermino(termino));
//        }
//        return "buscar";
//    }

    @RequestMapping("/historicoImc")
    public String historico(Model model,
                            @RequestParam(value = "idAtleta", required = false) Long idAtleta) {
        model.addAttribute("imcs",imcService.getHistorico(idAtleta));
        return "historicoImc";
    }

    @RequestMapping( value = "/perfil",  method = RequestMethod.GET)
    public String perfilPage(Model model,
                           @RequestParam(value = "idAtleta", required = false) Long idAtleta) {
        model.addAttribute(this.atletaService.get(idAtleta).get());
        return "perfil";
    }

    @RequestMapping(value = "/perfil",  method = RequestMethod.POST)
    public String perfilAction(Atleta atleta, BindingResult result, Model model) {
        atletaService.update(atleta);
        return "perfil";
    }

    @RequestMapping( value = "/editar",  method = RequestMethod.GET)
    public String editPage(Model model,
                           @RequestParam(value = "idAtleta", required = false) Long idAtleta) {
        model.addAttribute(this.atletaService.get(idAtleta).get());
        model.addAttribute("idAtleta", idAtleta);
        return "editar";
    }

    @RequestMapping(value = "/editar",  method = RequestMethod.POST)
    public String editAction(Atleta atleta, Long idAtleta, BindingResult result, Model model) {
        atletaService.update(atleta);
        return "editar";
    }

}
