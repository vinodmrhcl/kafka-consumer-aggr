package demo.toll.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TollTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long txnId;
	
	private Long vehicleId;
	private String vehicleSeqNumber;
	
	private String tagType;
	private String tagInstituion;
	private String tagNumber;
	private String tagStatus;
	private String accountStatus;
	
	private Integer vehicleSpeed;

	private Long tollPlazaId;
	private Long laneId;
	
	private Date txnTime;
	
}
