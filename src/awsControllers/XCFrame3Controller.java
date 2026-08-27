package awsControllers;
import awsMath.PreciseVector3;
import awsMath.PreciseXCFrame3;

public class XCFrame3Controller extends ControllerBase<PreciseXCFrame3, PreciseVector3> implements Controller<PreciseXCFrame3> {
	
	public XCFrame3Controller(PreciseXCFrame3 cFrame, PreciseVector3 startPosition) {
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
	
	public void spitSpangleDirect(PreciseVector3 directPositionIncrement) {
		this.CFrame.add(new PreciseXCFrame3(directPositionIncrement, 0)).me();
	}
	
	public void strafe(double distance, double directionRotation) {
		double radians = Math.toRadians(directionRotation);

	    double dx = Math.sin(radians) * distance;
	    double dy = Math.cos(radians) * distance;
	    
	    spitSpangleDirect(new PreciseVector3(dx, dy, 0d));
	}
	
	// resets CFrame
	public void recalibrate() {
		this.CFrame.position = this.StartPosition;
	}
}