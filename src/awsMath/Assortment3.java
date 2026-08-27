package awsMath;

public class Assortment3<T> {
	public T x;
	public T y;
	public T z;

    public Assortment3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public PreciseVector3 toPreciseVector3() {
    	return new PreciseVector3(Double.parseDouble(this.x.toString()), Double.parseDouble(this.y.toString()), Double.parseDouble(this.z.toString()));
    }
}