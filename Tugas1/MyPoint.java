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
        this.x = x;
        this.y = y;
    }

    /**
     * [1] jarak ke titik laen
     * @param o
     * @return
     */
    double distanceToOtherPoints(MyPoint o) {
		double dist = 0.0;
        //hitung dulu masing masing titiknya
        double A = this.x - o.x; 
        double B = this.y - o.y;
        
        //hitung jarak titik A dan B menggunakan rumus pitagoras
        dist = Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
        
		
        return dist;
    }
    
    /**
     * [2b] jarak ke segmen garis
     * @param l
     * @return
     */
    double distanceToLineSegment(MyLineSegment l) {
		double res = 0.0;
        //panggil aja dari l, l.distanceToPoint(this);
        res = l.distanceToPoint(null);
        return res;
    }
}
