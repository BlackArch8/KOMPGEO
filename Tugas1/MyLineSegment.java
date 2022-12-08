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
    double distanceToPoint(MyPoint p ) {
		double dist = 0.0;	//menyimpan jarak
        double dot = 0.0;
        

        dot = CG.dot(this.start, this.end, p);
        double x,y;
        x = this.end.x-this.start.x;
        
        y = this.end.y-this.start.y;
        
        double d = dot/(x*x + y*y);
        
       
       //kondisi jika dot product dari vektor pq dan vektor pr lebih besar dari 0
        if(d > 1){
            dist = this.end.distanceToOtherPoints(p); //maka hitung jarak dari titik awal ke titik

        //kondisi jika dot product dari vektor qp dan pr lebih besar dari 0
        }else if(d < 0){
            dist = this.start.distanceToOtherPoints(p); //maka hitung jarak dari titik akhir ke titik 
        }else{
            //sumber : https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment

            double A = this.end.x -this.start.x ; 
            double B = this.end.y-this.start.y ; 
            
            double xx = this.start.x + d * A;
            double yy = this.start.y + d * B;
            MyPoint temp = new MyPoint(xx, yy);
            // double dx = p.x-xx;
            // double dy = p.y-yy;
            // dist = Math.sqrt(dx * dx + dy * dy);
            dist = temp.distanceToOtherPoints(p);
            
        }
        


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
        //cari cross productnya 
        double d1 = CG.ccw(this.start, this.end, other.end);
        double d2 = CG.ccw(this.start, this.end, other.start);
        //cek apakah belok kiri dan belok kanan 
		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) ) {
             potong =  true;

             
        //degenerate case dimana kedua garis saling tepat menyentuh
        //ada 2 kondisi yaitu:
        //ketika koordinat x titik 1 sama dengan koordinat x titik 2 sama dengan koordinat x titik 4
        //ketika koordinat y titik 1 sama dengan koordinat y titik 2 sama dengan koordinat y titik 4
        }else if((this.start.x == this.end.x && this.start.x == other.end.x) || (this.start.y == this.end.y && this.start.y == other.end.y)){
            potong = true;
        }
        return potong;
    }

}