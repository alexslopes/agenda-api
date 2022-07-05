package io.githube.alexstlopes.agendaapi.model.api.rest;

import io.githube.alexstlopes.agendaapi.model.entity.Contato;
import io.githube.alexstlopes.agendaapi.model.reposotry.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor//Cria um construtor com argumentos obrigatórios
@CrossOrigin("*")
public class ContatoController {

    private final ContatoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save(@RequestBody Contato contato){
        return repository.save(contato);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping
    public List<Contato> list(){
        return repository.findAll();
    }

    @PatchMapping("{id}/favorito")//Utilizado ao fazer atualização de uma propriedade em vez de todo o objeto,(seria o PUT)
    public void favorite(@PathVariable Integer id, @RequestBody Boolean favorito){
        Optional<Contato> contato = repository.findById(id);
        contato.ifPresent( c -> {
            c.setFavorito(favorito);
            repository.save(c);
        });
    }
}
