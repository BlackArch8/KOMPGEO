public class MyPoint {
    /**deklarasi koordinat x titik*/
    public double x;
    /** deklarasi koordinat y titik */
    public double y;

    /**
     * konstruktor
     * @param x
     * @param y
     */
    MyPoint (double x, double y) {
        this.x = x; //mengisi variabel x di class MyPoint dengan parameter x
        this.y = y; //mengisi variabel y di class MyPoint dengan parameter y
    }

    /**
     * [1] jarak ke titik laen
     * @param o
     * @return
     */
    double distanceToOtherPoints(MyPoint o) {
		double dist = 0.0; //deklarasi variabel jarak
        //hitung dulu masing masing titiknya
        double A = this.x - o.x; 
        double B = this.y - o.y;
        
        //hitung jarak titik A dan B menggunakan rumus pitagoras
        dist = Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
        
		//return jarak
        return dist;
    }
    
    /**
     * [2b] jarak ke segmen garis
     * @param l
     * @return
     */
    double distanceToLineSegment(MyLineSegment l) {
		double res = 0.0; //deklarasi hasil(jarak titik ke segmen garis)
        //panggil aja dari l, l.distanceToPoint(this);
        res = l.distanceToPoint(null); //memanggil method distanceToPoint untuk mencari jarak titik ke segmen garis
        return res; //return hasil
    }
}
