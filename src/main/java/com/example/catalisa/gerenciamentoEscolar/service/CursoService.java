package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTO;
import com.example.catalisa.gerenciamentoEscolar.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    //MÉTODOS

    //listar todos os cadastros
    public List<CursoDTO> exibirCursos(){

        List<CursoModel> cursos = cursoRepository.findAll();
        List<CursoDTO> cursosDTO = new ArrayList<>();

        for(CursoModel curso: cursos){
            cursosDTO.add(new CursoDTO(curso));
        }
        return cursosDTO;
    }

    // fazer um novo cadastro

    public CursoDTO cadastrarCurso(CursoDTO cursoDTO){

        CursoModel novoCurso = cursoRepository.save(cursoDTO.toCursoModel());
        return new CursoDTO(novoCurso);
    }

    // deletar cadastro
    public void excluirCurso(Long id){
        cursoRepository.deleteById(id);
    }
}
