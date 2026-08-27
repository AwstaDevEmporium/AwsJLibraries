package awsMath;
import awsGeneral.AWSResult;
import awsGeneral.Resultable;

public class PreciseXCFrame3 implements CFrame, Resultable<PreciseXCFrame3> {
	public PreciseVector3 position = new PreciseVector3(0,0,0);
	public double xRotation = 0d; // in degrees
	
	private static double overflowDegrees(double in) {
		return in % 360;
	}
	
	public PreciseXCFrame3(PreciseVector3 position, double xRotation) {
		this.position = position;
		this.xRotation = overflowDegrees(xRotation);
	}
	
	@Override
	public void set(PreciseXCFrame3 val) {
		this.position = new PreciseVector3(val.position.x, val.position.y, val.position.z);
		this.xRotation = val.xRotation;
	}
	
	public AWSResult<PreciseXCFrame3> add(PreciseXCFrame3 other) {
		return new AWSResult<PreciseXCFrame3>(this, new PreciseXCFrame3(this.position.add(other.position).result(), overflowDegrees(this.xRotation + other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame3> subtract(PreciseXCFrame3 other) {
		return new AWSResult<PreciseXCFrame3>(this, new PreciseXCFrame3(this.position.subtract(other.position).result(), overflowDegrees(this.xRotation - other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame3> multiply(PreciseXCFrame3 other) {
		return new AWSResult<PreciseXCFrame3>(this, new PreciseXCFrame3(this.position.multiply(other.position).result(), overflowDegrees(this.xRotation * other.xRotation)));
	}

	public AWSResult<PreciseXCFrame3> divide(PreciseXCFrame3 other) {
		return new AWSResult<PreciseXCFrame3>(this, new PreciseXCFrame3(this.position.divide(other.position).result(), overflowDegrees(this.xRotation / other.xRotation)));
	}
	
	public AWSResult<PreciseXCFrame3> negate() {
		return new AWSResult<PreciseXCFrame3>(this, new PreciseXCFrame3(this.position.negate().result(), -this.xRotation));
	}
	
	public void safeSetRotation(double theRotRot67) {
		xRotation = overflowDegrees(theRotRot67);
	}
}