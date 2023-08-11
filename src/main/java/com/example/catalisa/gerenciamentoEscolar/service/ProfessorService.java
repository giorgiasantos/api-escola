package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTO;
import com.example.catalisa.gerenciamentoEscolar.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    //MÉTODOS

    //listar todos os cadastros
//    public List<ProfessorModel> exibirProfessores(){
//        List<ProfessorModel> professores = professorRepository.findAll();
//
//        return professores;
//    }

    public List<ProfessorDTO> exibirProfessores(){
        List<ProfessorModel> professores = professorRepository.findAll();
        List<ProfessorDTO> professoresDTO = new ArrayList<>();

        for(ProfessorModel professor: professores){
            professoresDTO.add(new ProfessorDTO(professor));
        }
        return professoresDTO;
    }

    // fazer um novo cadastro
//    public ProfessorModel cadastrarProfessor(ProfessorModel professorModel){
//        return professorRepository.save(professorModel);
//
//    }
    public ProfessorDTO cadastrarProfessor(ProfessorDTO professorDTO){
        ProfessorModel novoProfessor = professorRepository.save(professorDTO.toProfessorModel());
        return new ProfessorDTO(novoProfessor);
    }

    // deletar cadastro
    public void excluirProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
