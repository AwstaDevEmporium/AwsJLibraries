package awsControllers;
import awsMath.CFrame;
import awsMath.PrecisionVector;

public abstract class ControllerBase<T extends CFrame, T2 extends PrecisionVector> {
	public T CFrame;
	public T2 StartPosition;
	
	public ControllerBase(T cFrame, T2 startPosition) {
		this.CFrame = cFrame;
		this.StartPosition = startPosition;
	}
}