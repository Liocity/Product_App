package in.ashokit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class product {
	@Id
	@GeneratedValue
	private Integer pid;
	@NotBlank(message="Product Name Is Mandatory")
	@Size(min=3,max=15 ,message="Name Should Have Only 3 to 15 Charecters")
	private String name;
	@Positive(message="Price Should be Positive Number")
	@NotNull(message="Product Price Is Mandatory")
	private Double price;
	@Positive(message="Quantity Should be Positive Number")
	@NotNull(message="Product Qty Is Mandatory")
	private Integer qty;

}
