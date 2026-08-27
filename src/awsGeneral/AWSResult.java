package awsGeneral;

public class AWSResult<T extends Resultable<T>> {
	private T _result;
	private T source;
	
	public AWSResult(T source, T result) {
		this._result = result;
		this.source = source;
	}
	
	public AWSResult<T> me() {
		source.set(_result);
		return this;
	}
	
	public T result() {
		return _result;
	}
}