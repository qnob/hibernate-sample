package ch.qnob.sample.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRUCK")
@DiscriminatorValue("T")
public class Truck extends Vehicle {

 
    @Column(name="max_load")
    private Integer maxLoad;

	public Integer getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(Integer maxLoad) {
		this.maxLoad = maxLoad;
	}

}
