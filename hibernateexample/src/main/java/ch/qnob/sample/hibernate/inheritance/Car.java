package ch.qnob.sample.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@DiscriminatorValue("C")
public class Car extends Vehicle {

 
    @Column(name="color")
    private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
  
   
}
