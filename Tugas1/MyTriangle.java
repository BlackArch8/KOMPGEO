
public class MyTriangle {
    /** Deklarasi atribut */
    MyPoint a,b,c;

    /**
     * konstruktor
     * @return
     */
    public MyTriangle(MyPoint a, MyPoint b, MyPoint c) {
        //set atribut a,b,c pada class MyTriangle dengan parameter a,b,c
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
		double area = 0.0; //inisialisasi
        //sumber : https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/geometry/Triangle.java
        double ab,bc,ca; //inisialisasi jarak antar titik
        //hitung panjang masing masing sisi segitiganya
        ab = this.a.distanceToOtherPoints(b); bc = this.b.distanceToOtherPoints(c); ca = this.c.distanceToOtherPoints(a);
        
        double s = (ab + bc + ca) / 2.0; //hitung semiperimeter(setengah keliling segitiga)
		area = Math.sqrt(s * (s - ab) * (s - bc) * (s - ca)); //hitung luas segitiga(segitiga sembarang)
    
        return area;
    }

}
