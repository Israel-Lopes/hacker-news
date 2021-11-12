package br.com.greatnews.news.repository;

import br.com.greatnews.news.model.NoticiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel, Long> {
}
