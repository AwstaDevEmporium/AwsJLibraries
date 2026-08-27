package awsMath;
import awsGeneral.Resultable;
import awsGeneral.AWSResult;

public class PreciseVector3 implements PrecisionVector, Resultable<PreciseVector3> {
	public double x = 0d;
	public double y = 0d;
	public double z = 0d;
	
	public PreciseVector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// interfaces Resultable, so it can be used with AWSResult<whatever the fuh>
	@Override
	public void set(PreciseVector3 val) {
		this.x = val.x;
		this.y = val.y;
		this.z = val.z;
	}
	
	public AWSResult<PreciseVector3> add(PreciseVector3 other) {
	    return new AWSResult<PreciseVector3>(this, new PreciseVector3(this.x + other.x, this.y + other.y, this.z + other.z));
	}
	
	public AWSResult<PreciseVector3> subtract(PreciseVector3 other) {
		return new AWSResult<PreciseVector3>(this, new PreciseVector3(this.x - other.x, this.y - other.y, this.z - other.z));
	}
	
	public AWSResult<PreciseVector3> negate() {
		return new AWSResult<PreciseVector3>(this, new PreciseVector3(-this.x, -this.y, -this.z));
	}
	
	public AWSResult<PreciseVector3> multiply(PreciseVector3 other) {
		return new AWSResult<PreciseVector3>(this, new PreciseVector3(this.x * other.x, this.y * other.y, this.z * other.z));
	}
	
	public AWSResult<PreciseVector3> divide(PreciseVector3 other) {
		return new AWSResult<PreciseVector3>(this, new PreciseVector3(this.x / other.x, this.y / other.y, this.z / other.z));
	}
	
	public Assortment3<Double> toAssortment3() {
		return new Assortment3<Double>(this.x, this.y, this.z);
	}
	
	// lossy convert here :(
	public PreciseVector2 toPreciseVector2() {
		return new PreciseVector2(this.x, this.y);
	}
}