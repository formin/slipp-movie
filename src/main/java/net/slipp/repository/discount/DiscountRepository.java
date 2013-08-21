package net.slipp.repository.discount;

import net.slipp.domain.discount.Discount;  
import org.springframework.data.repository.CrudRepository;


public interface DiscountRepository extends CrudRepository<Discount, String> {

}
