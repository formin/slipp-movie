package net.slipp.domain.discount;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import net.slipp.domain.movie.Money;
import net.slipp.domain.showing.Showing;

@Entity
public abstract class DiscountNon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nonId = 1;
	
	@OneToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_discountpercent_parent_id")
	private Discount discountId;
	 
	protected Money getDiscountedFee(Showing showing){
		return showing.getFixedFee();
	}
	
}
