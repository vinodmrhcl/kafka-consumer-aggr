package demo.toll.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Entity
@RedisHash
public class TollTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
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
