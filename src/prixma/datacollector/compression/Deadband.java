package prixma.datacollector.compression;


public class Deadband {
	
	private Double highLimit;
	private Double lowLimit;
	private Double deviation;
	private Double value;
	
	public Deadband(Double value, Double deviation){
		this.deviation = deviation;
		this.value = value;
		this.highLimit = value + deviation;
		this.lowLimit = value - deviation;
	}

	public Double getHighLimit() {
		return highLimit;
	}

	public Double getLowLimit() {
		return lowLimit;
	}

	public Double getDeviation() {
		return deviation;
	}
	
	public boolean isInside(){
		return inRange();
	}
	
	
	public boolean isOutside(Double value){
		return !inRange(value);
	}
	
	
	private boolean inRange(){
		return inRange(this.value);
	}

	private boolean inRange(Double value){
		return value > lowLimit && value < highLimit;
	}
}
