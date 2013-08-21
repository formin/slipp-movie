package net.slipp.repository.movie;
 
import net.slipp.domain.movie.Movie;   
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String> {

}
