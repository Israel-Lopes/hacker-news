package br.com.greatnews.news.controller;

import br.com.greatnews.news.model.NoticiaModel;
import br.com.greatnews.news.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @GetMapping
    public List<NoticiaModel> list() {
        return noticiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticiaModel> getNoticia(@PathVariable Long id) {
        NoticiaModel noticiaModel = noticiaRepository.findById(id).get();
        return ResponseEntity.ok(noticiaModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoticiaModel addNoticia(@RequestBody NoticiaModel noticia) {
        return noticiaRepository.save(noticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity update
            (@PathVariable Long id, @RequestBody NoticiaModel noticia) {
        return noticiaRepository.findById(id)
                .map(record -> {
                    record.setTitulo(noticia.getTitulo());
                    record.setDescricao(noticia.getDescricao());
                    NoticiaModel update = noticiaRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        noticiaRepository.findById(id);
        noticiaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
