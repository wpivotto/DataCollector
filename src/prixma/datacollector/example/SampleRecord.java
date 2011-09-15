package prixma.datacollector.example;

import prixma.datacollector.compression.Deadband;
import prixma.datacollector.compression.Record;


public class SampleRecord implements Record {
	
	private Double rangeMin;
	
	private Double rangeMax;
	
	private Double compressionDeviation;
	
	private Long compressionMaximumTime, compressionMinimumTime;
	
	private Long timestamp;
	
	private Long id;
	
	private Double value;
	
	private String description;
	
	public SampleRecord(String description){
		this.description = description;
	}
	
	public Double getRangeMin() {
		return rangeMin;
	}
	
	public void setRangeMin(Double rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Double getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Double rangeMax) {
		this.rangeMax = rangeMax;
	}

	public Double getCompressionDeviation() {
		return compressionDeviation;
	}

	public void setCompressionDeviation(Double compressionDeviation) {
		this.compressionDeviation = compressionDeviation;
	}

	public Long getCompressionMaximumTime() {
		return compressionMaximumTime;
	}

	public void setCompressionMaximumTime(Long compressionMaximumTime) {
		this.compressionMaximumTime = compressionMaximumTime;
	}

	public Long getCompressionMinimumTime() {
		return compressionMinimumTime;
	}

	public void setCompressionMinimumTime(Long compressionMinimumTime) {
		this.compressionMinimumTime = compressionMinimumTime;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Deadband getDeadband() {
		return new Deadband(getValue(), getCompressionDeviation());
	}
	

	public boolean isOutside(Deadband deadband){
		return deadband.isOutside(getValue());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleRecord other = (SampleRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getDescription() + " [" + getValue() + "]";
	}

	



}
