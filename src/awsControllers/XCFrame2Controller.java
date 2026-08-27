package awsControllers;
import awsMath.PreciseVector2;
import awsMath.PreciseXCFrame2;

public class XCFrame2Controller extends ControllerBase<PreciseXCFrame2, PreciseVector2> implements Controller<XCFrame2Controller> {
	
	public XCFrame2Controller(PreciseXCFrame2 cFrame, PreciseVector2 startPosition) {
		super(cFrame, startPosition);
	}
	
	public void directForward(double distance) {
	    strafe(distance, this.CFrame.xRotation);
	}
	
	public void rotateBy(double rotation) {
	    this.CFrame.safeSetRotation(this.CFrame.xRotation + rotation);
	}
	
	public void rotateTo(double rotation) {
	    this.CFrame.safeSetRotation(rotation);
	}
	
	public void spitSpangleDirect(PreciseVector2 directPositionIncrement) {
		this.CFrame.add(new PreciseXCFrame2(directPositionIncrement, 0)).me();
	}
	
	public void strafe(double distance, double directionRotation) {
		double radians = Math.toRadians(directionRotation);

	    double dx = Math.sin(radians) * distance;
	    double dy = Math.cos(radians) * distance;
	    
	    spitSpangleDirect(new PreciseVector2(dx, dy));
	}
	
	// resets CFrame
	public void recalibrate() {
		this.CFrame.position = this.StartPosition;
	}
}