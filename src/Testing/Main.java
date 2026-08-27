package Testing;
import awsControllers.XCFrame2Controller;
import awsMath.PreciseVector2;
import awsMath.PreciseXCFrame2;

public class Main {
	private static void diagnose(XCFrame2Controller controller) {
		System.out.println("x" + controller.CFrame.position.x);
		System.out.println("y" +controller.CFrame.position.y);
		System.out.println();
	}
	
	public static void main(String[] args) {
		PreciseXCFrame2 newFrame = new PreciseXCFrame2(new PreciseVector2(0,0), 0d);
		PreciseVector2 startPos = new PreciseVector2(0,0);
		
		XCFrame2Controller controller = new XCFrame2Controller(newFrame, startPos);
		
		diagnose(controller);
		controller.directForward(20);
		diagnose(controller);
		controller.rotateBy(90);
		controller.directForward(20);
		diagnose(controller);
	}
}