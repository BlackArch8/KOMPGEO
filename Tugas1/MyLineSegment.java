public class MyLineSegment {
    /** ``vektor'' dari start ke end */
    MyPoint start;
    /** komen di sini */
    MyPoint end;

    /**
     * konstruktor
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start;
        this.end = end;
    }

    /**
     * [2a] jarak ke titik
     * @param p
     * @return
     */
    double distanceToPoint(MyPoint p) {
		double dist = 0.0;	//menyimpan jarak
        // persamaanGaris
        // dist = 
        return dist;
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * @param target
     * @return
     */
    double leftTurnToPoint(MyPoint target) {
		double res = 0.0;
		res = CG.ccw(this.start, this.end, target);
        return res; //return 0 jika lurus, plus/minus jika belok kanan/kiri,  
    }
    
    /**
     * [4] motong segmen laen?
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
		boolean potong = false;
        double d1 = CG.ccw(this.start, this.end, other.end);
        double d2 = CG.ccw(this.start, this.end, other.start);
        
		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) ) {
             potong =  true;
        }
        return potong;
    }

}