package awsMath;
import awsGeneral.AWSResult;
import awsGeneral.Resultable;

public class PreciseVector2 implements PrecisionVector, Resultable<PreciseVector2> {
	public double x = 0d;
	public double y = 0d;
	
	public PreciseVector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// interfaces Resultable, so it can be used with AWSResult<whatever the fuh>
	@Override
	public void set(PreciseVector2 val) {
		this.x = val.x;
		this.y = val.y;
	}
	
	public AWSResult<PreciseVector2> add(PreciseVector2 other) {
	    return new AWSResult<PreciseVector2>(this, new PreciseVector2(this.x + other.x, this.y + other.y));
	}
	
	public AWSResult<PreciseVector2> subtract(PreciseVector2 other) {
		return new AWSResult<PreciseVector2>(this, new PreciseVector2(this.x - other.x, this.y - other.y));
	}
	
	public AWSResult<PreciseVector2> negate() {
		return new AWSResult<PreciseVector2>(this, new PreciseVector2(-this.x, -this.y));
	}
	
	public AWSResult<PreciseVector2> multiply(PreciseVector2 other) {
		return new AWSResult<PreciseVector2>(this, new PreciseVector2(this.x * other.x, this.y * other.y));
	}
	
	public AWSResult<PreciseVector2> divide(PreciseVector2 other) {
		return new AWSResult<PreciseVector2>(this, new PreciseVector2(this.x / other.x, this.y / other.y));
	}
	
	public Assortment2<Double> toAssortment2() {
		return new Assortment2<Double>(this.x, this.y);
	}
	
	public PreciseVector3 toPreciseVector3() {
		return new PreciseVector3(this.x, this.y, 0d);
	}
}