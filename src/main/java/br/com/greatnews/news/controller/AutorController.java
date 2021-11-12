package br.com.greatnews.news.controller;

import br.com.greatnews.news.model.AutorModel;
import br.com.greatnews.news.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<AutorModel> list() {
        return autorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorModel addAutor(@RequestBody AutorModel autor) {
        return autorRepository.save(autor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> getAuto(@PathVariable Long id) {
        AutorModel autorModel = autorRepository.findById(id).get();
        return ResponseEntity.ok(autorModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity update
            (@PathVariable Long id, @RequestBody AutorModel autor) {
        return autorRepository.findById(id)
                .map(record -> {
                    record.setNome(autor.getNome());
                    AutorModel update = autorRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
