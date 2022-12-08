public class MyLineSegment {
    /** ``vektor'' dari start ke end */
    MyPoint start;
    /**titik end dari vektor*/
    MyPoint end;

    /**
     * konstruktor
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start; //set atribut start di class MyLineSegment dengan parameter start
        this.end = end; //set atribut end di class MyLineSegment dengan parameter end 
    }

    /**
     * [2a] jarak ke titik
     * @param p
     * @return
     */                                         
    double distanceToPoint(MyPoint p ) {
		double dist = 0.0;	//inisialisasi jarak
        double dot = 0.0; //inisialisasi dot product
        

        dot = CG.dot(this.start, this.end, p); //menghitung dot product dari titik awal segmen garis, titik akhir segmen garis, dan titik yang dicari jaraknya ke segmen garis
        double x,y;//inisialisasi
        
        //hitung masing masing titiknya
        x = this.end.x-this.start.x; 
        y = this.end.y-this.start.y;
        
        double d = dot/(x*x + y*y); //menghitung dot product dari vektor pq dan vektor pr
        
       
       //kondisi jika dot product dari vektor pq dan vektor pr lebih besar dari 1
        if(d > 1){
            dist = this.end.distanceToOtherPoints(p); //maka hitung jarak dari titik q ke titik p

        //kondisi jika dot product dari vektor qp dan pr lebih kecil dari 0
        }else if(d < 0){
            dist = this.start.distanceToOtherPoints(p); //maka hitung jarak dari titik r ke titik p

        //kondisi pada saat jarak terdekat antara titik dengan segmen garis adalah ke tengah segmen      
        }else{
            //sumber : https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment

            double xx = this.start.x + d * x; //cari koordinat x untuk titik baru
            double yy = this.start.y + d * y; //cari koordinat y untuk titik baru
            MyPoint temp = new MyPoint(xx, yy);//instansiasi titik untuk koordinat xx dan yy
            
            dist = temp.distanceToOtherPoints(p); //menghitung jarak dari segmen garis ke titik target dengan cara menghitung jarak dari titik temp ke titik target
            
        }
        


        return dist; //return jarak dari segmen garis ke titik target
        
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * @param target
     * @return
     */
    double leftTurnToPoint(MyPoint target) {
		double res = 0.0; //inisialisasi hasil/res
		res = CG.ccw(this.start, this.end, target); //mencari nilai cross product dari titik awal dan akhir segmen garis serta titik targetnya
        return res; //return 0 jika lurus, plus/minus jika belok kanan/kiri,  
    }
    
    /**
     * [4] motong segmen laen?
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
		boolean potong = false; //set tidak berpotongan terlebih dahulu
        //cari cross productnya 
        double d1 = CG.ccw(this.start, this.end, other.end);
        double d2 = CG.ccw(this.start, this.end, other.start);
        //cek apakah belok kiri dan belok kanan 
		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) ) {
             potong =  true; //set berpotongan jika memenuhi kondisi

             
        //degenerate case dimana kedua garis saling tepat menyentuh
        //ada 2 kondisi yaitu:
        //ketika koordinat x titik 1 sama dengan koordinat x titik 2 sama dengan koordinat x titik 4
        //ketika koordinat y titik 1 sama dengan koordinat y titik 2 sama dengan koordinat y titik 4
        }else if((this.start.x == this.end.x && this.start.x == other.end.x) || (this.start.y == this.end.y && this.start.y == other.end.y)){
            potong = true; //set berpotongan jika memenuhi kondisi
        }
        return potong;
    }

}