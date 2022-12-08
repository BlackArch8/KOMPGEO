
public class MyTriangle {
    /** Deklarasi atribut */
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
        //sumber : https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/geometry/Triangle.java
        double ab,bc,ca;
        ab = this.a.distanceToOtherPoints(b); bc = this.b.distanceToOtherPoints(c); ca = this.c.distanceToOtherPoints(a);
        double s = (ab + bc + ca) / 2.0;
		area = Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));	
    
        return area;
    }

}
