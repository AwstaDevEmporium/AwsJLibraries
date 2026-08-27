package awsMath;
import awsGeneral.AWSResult;
import awsGeneral.Resultable;

public class PreciseEulerCFrame2 implements CFrame, Resultable<PreciseEulerCFrame2> {
	public PreciseVector2 position = new PreciseVector2(0,0);
	public PreciseVector2 eulerOrientation = new PreciseVector2(0,0);
	
	public PreciseEulerCFrame2(PreciseVector2 position, PreciseVector2 eulerOrientation) {
		this.position = position;
		this.eulerOrientation = eulerOrientation;
	}
	
	@Override
	public void set(PreciseEulerCFrame2 val) {
	    this.position = new PreciseVector2(val.position.x, val.position.y);

	    this.eulerOrientation = new PreciseVector2(val.eulerOrientation.x, val.eulerOrientation.y);
	}
	
	public AWSResult<PreciseEulerCFrame2> add(PreciseEulerCFrame2 other) {
		return new AWSResult<PreciseEulerCFrame2>(this, new PreciseEulerCFrame2(this.position.add(other.position).result(), this.eulerOrientation.add(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame2> subtract(PreciseEulerCFrame2 other) {
		return new AWSResult<PreciseEulerCFrame2>(this, new PreciseEulerCFrame2(this.position.subtract(other.position).result(), this.eulerOrientation.subtract(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame2> multiply(PreciseEulerCFrame2 other) {
		return new AWSResult<PreciseEulerCFrame2>(this, new PreciseEulerCFrame2(this.position.multiply(other.position).result(), this.eulerOrientation.multiply(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame2> divide(PreciseEulerCFrame2 other) {
		return new AWSResult<PreciseEulerCFrame2>(this, new PreciseEulerCFrame2(this.position.divide(other.position).result(), this.eulerOrientation.divide(other.eulerOrientation).result()));
	}
	
	public AWSResult<PreciseEulerCFrame2> negate() {
		return new AWSResult<PreciseEulerCFrame2>(this, new PreciseEulerCFrame2(this.position.negate().result(), this.eulerOrientation.negate().result()));
	}
	
	public PreciseEulerCFrame3 toPreciseEulerCFrame3() {
		return new PreciseEulerCFrame3(this.position.toPreciseVector3(), this.eulerOrientation.toPreciseVector3());
	}
	
	// one way
	public Assortment2<PreciseVector2> toAssortment2() {
		return new Assortment2<PreciseVector2>(this.position, this.eulerOrientation);
	}
}
