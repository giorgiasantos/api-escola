package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTO;
import com.example.catalisa.gerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    //MÉTODOS

   // atualizar matricula do aluno
    public MatriculaModel editarMatricula(Long id, Long cursosId){ //tentar lugar pra long

        MatriculaModel matriculaModel = matriculaRepository.findById(id).orElse(null);

        if(matriculaModel != null){
            matriculaModel.setCursosId(cursosId);
            return matriculaRepository.save(matriculaModel);
        }
        return null;
    }

    //listar todos os cadastros
//    public List<MatriculaModel> exibirMatriculas(){
//
//        List<MatriculaModel> matriculas = matriculaRepository.findAll();
//
//        return matriculas;
//    }
    public List<MatriculaDTO> exibirMatriculas(){

        List<MatriculaModel> matriculas = matriculaRepository.findAll();
        List<MatriculaDTO> matriculasDTO = new ArrayList<>();

        for(MatriculaModel matricula : matriculas){
            matriculasDTO.add(new MatriculaDTO(matricula));
        }
        return matriculasDTO;
    }

    // fazer um novo cadastro
//    public MatriculaModel fazerMatricula(MatriculaModel matriculaModel){
//
//        return matriculaRepository.save(matriculaModel);
//    }

    public MatriculaDTO fazerMatricula(MatriculaDTO matriculaDTO){
        MatriculaModel novaMatricula = matriculaRepository.save(matriculaDTO.toMatriculaModel());
        return new MatriculaDTO(novaMatricula);
    }


//    // deletar cadastro
    public void excluirMatricula(Long id){

        matriculaRepository.deleteById(id);
    }

}
