package io.githube.alexstlopes.agendaapi.model.reposotry;

import io.githube.alexstlopes.agendaapi.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
