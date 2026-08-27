package awsMath;

public class Assortment2<T> {
    public T x;
    public T y;

    public Assortment2(T x, T y) {
        this.x = x;
        this.y = y;
    }
    
    public PreciseVector2 toPreciseVector2() {
    	return new PreciseVector2(Double.parseDouble(this.x.toString()), Double.parseDouble(this.y.toString()));
    }
}