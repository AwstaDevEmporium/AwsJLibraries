package awsGeneral;

public interface Resultable<T> {
	default void set(T val) {}
}