
public class MyTriangle {
    /**  */
    MyPoint a,b,c;

    /**
     * konstruktor
     * @return
     */
    public MyTriangle(MyPoint a, MyPoint b, MyPoint c) {
        this.a = a;
		this.b = b;
		this.c = c;
    }

    /**
     * 
     * @param 
     * @return
     */
    double area() {
		double area = 0.0;
        double a = (this.a.distanceToOtherPoints(this.c));
        MyLineSegment l = new MyLineSegment(this.a,this.c);
        double t = 3;  
		area = 0.5*a*t;
        return area;
    }

}
