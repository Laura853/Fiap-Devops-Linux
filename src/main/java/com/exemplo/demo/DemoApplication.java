package com.exemplo.demo;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno dados) {
        return repository.findById(id).map(aluno -> {
            aluno.nome = dados.nome;
            aluno.ra = dados.ra;
            aluno.curso = dados.curso;
            return ResponseEntity.ok(repository.save(aluno));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

@Entity
class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String ra;
    public String curso;

    public Aluno() {}
    public Aluno(String nome, String ra, String curso) {
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
    }
}

interface AlunoRepository extends JpaRepository<Aluno, Long> {}
