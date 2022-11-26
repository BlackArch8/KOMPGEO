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
        MyPoint pq = new MyPoint(this.start.x - p.x,this.start.y-p.y ); //instansiasi vektor pq
        MyPoint qr = new MyPoint(this.end.x - this.start.x,this.end.y-this.start.y ); //instansiasi vektor qr

        MyPoint qp = new MyPoint(p.x-this.start.x,p.y-this.start.y); //instansiasi vektor qp
        MyPoint pr = new MyPoint(this.end.x-p.x,this.end.y-p.y); //instansiasi vektor pr

        double pqdotpr = pq.x*qr.x+pq.y*qr.y; //mencari dot product dari vektor pq dan pr

        double qpdotpr = qp.x*pr.x+qp.y*pr.y; //mencari dot product dari vektor qp dan vektor pr
       
       //kondisi jika dot product dari vektor pq dan vektor pr lebih besar dari 0
        if(pqdotpr> 0){
            dist = this.start.distanceToOtherPoints(p); //maka hitung jarak dari titik awal ke titik

        //kondisi jika dot product dari vektor qp dan pr lebih besar dari 0
        }else if(qpdotpr> 0){
            dist = this.end.distanceToOtherPoints(p); //maka hitung jarak dari titik akhir ke titik 
        }else{
            //distancenya masih belum benar kemungkinan rumusnya masih salah 
            double A = this.start.x - this.end.x; 
            double B = this.start.y - this.end.y;
            double c = A * this.start.x + B * this.end.y;
            
            if(B>0){
                dist = Math.abs((p.x *A) + (p.y *B) - c) / Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));

            }else{
                dist = Math.abs((p.x *A) - (p.y *B) + c) / Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
            }
            
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