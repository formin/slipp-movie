package net.slipp.repository.reservation;
 
import net.slipp.domain.reservation.Reservation;  
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String> {

}
