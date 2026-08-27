package awsMath;

import awsGeneral.AWSResult;
import awsGeneral.Resultable;

public class PreciseEulerCFrame3 implements CFrame, Resultable<PreciseEulerCFrame3> {
	public PreciseVector3 position = new PreciseVector3(0d,0d,0d);
	public PreciseVector3 eulerOrientation = new PreciseVector3(0d,0d,0d);
	
	public PreciseEulerCFrame3(PreciseVector3 position, PreciseVector3 eulerOrientation) {
		this.position = position;
		this.eulerOrientation = eulerOrientation;
	}
	
	@Override
	public void set(PreciseEulerCFrame3 val) {
	    this.position = new PreciseVector3(val.position.x, val.position.y, val.position.z);

	    this.eulerOrientation = new PreciseVector3(val.eulerOrientation.x, val.eulerOrientation.y, val.eulerOrientation.z);
	}
	
	public AWSResult<PreciseEulerCFrame3> add(PreciseEulerCFrame3 other) {
		return new AWSResult<PreciseEulerCFrame3>(this, new PreciseEulerCFrame3(this.position.add(other.position).result(), this.eulerOrientation.add(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame3> subtract(PreciseEulerCFrame3 other) {
		return new AWSResult<PreciseEulerCFrame3>(this, new PreciseEulerCFrame3(this.position.subtract(other.position).result(), this.eulerOrientation.subtract(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame3> multiply(PreciseEulerCFrame3 other) {
		return new AWSResult<PreciseEulerCFrame3>(this, new PreciseEulerCFrame3(this.position.multiply(other.position).result(), this.eulerOrientation.multiply(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame3> divide(PreciseEulerCFrame3 other) {
		return new AWSResult<PreciseEulerCFrame3>(this, new PreciseEulerCFrame3(this.position.divide(other.position).result(), this.eulerOrientation.divide(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame3> negate() {
		return new AWSResult<PreciseEulerCFrame3>(this, new PreciseEulerCFrame3(this.position.negate().result(), this.eulerOrientation.negate().result()));
	}
	
	// again, very lossy
	public PreciseEulerCFrame2 toPreciseEulerCFrame2() {
		return new PreciseEulerCFrame2(this.position.toPreciseVector2(), this.eulerOrientation.toPreciseVector2());
	}
	
	// one way
	public Assortment2<PreciseVector3> toAssortment2() {
		return new Assortment2<PreciseVector3>(this.position, this.eulerOrientation);
	}
}