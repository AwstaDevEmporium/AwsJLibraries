package awsMath;
import awsGeneral.AWSResult;
import awsGeneral.Resultable;

public class PreciseXCFrame2 implements CFrame, Resultable<PreciseXCFrame2> {
	public PreciseVector2 position = new PreciseVector2(0,0);
	public double xRotation = 0d; // in degrees
	
	private static double overflowDegrees(double in) {
		return in % 360;
	}
	
	@Override
	public void set(PreciseXCFrame2 val) {
		this.position = new PreciseVector2(val.position.x, val.position.y);
		this.xRotation = overflowDegrees(val.xRotation);
	}
	
	public PreciseXCFrame2(PreciseVector2 position, double xRotation) {
		this.position = position;
		this.xRotation = overflowDegrees(xRotation);
	}
	
	public AWSResult<PreciseXCFrame2> add(PreciseXCFrame2 other) {
		return new AWSResult<PreciseXCFrame2>(this, new PreciseXCFrame2(this.position.add(other.position).result(), overflowDegrees(this.xRotation + other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame2> subtract(PreciseXCFrame2 other) {
		return new AWSResult<PreciseXCFrame2>(this, new PreciseXCFrame2(this.position.subtract(other.position).result(), overflowDegrees(this.xRotation - other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame2> multiply(PreciseXCFrame2 other) {
		return new AWSResult<PreciseXCFrame2>(this, new PreciseXCFrame2(this.position.multiply(other.position).result(), overflowDegrees(this.xRotation * other.xRotation)));
	}

	public AWSResult<PreciseXCFrame2> divide(PreciseXCFrame2 other) {
		return new AWSResult<PreciseXCFrame2>(this, new PreciseXCFrame2(this.position.divide(other.position).result(), overflowDegrees(this.xRotation / other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame2> negate() {
		return new AWSResult<PreciseXCFrame2>(this, new PreciseXCFrame2(this.position.negate().result(), -this.xRotation));
	}
	
	public void safeSetRotation(double theRotRot67) {
		xRotation = overflowDegrees(theRotRot67);
	}
}
