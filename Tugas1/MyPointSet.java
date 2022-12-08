import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class MyPointSet {
    /**  */
    List<MyPoint> Points;
    

    /**
     * konstruktor
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>(); //instansiasi array list untuk kumpulan titik(point set)
    }

    /**
     * [8a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p); //memasukan titik ke array list Points
        return true;
    }

    public MyPoint carititikTerkecil(){
        MyPoint titikTerkecil = this.Points.get(0); //set titik paling kecil dengan titik pada arraylist index 0(sementara)
        //looping array list untuk mencari titik terkecil
        for(int i = 0;i<this.Points.size()-1;i++){
            MyPoint cek = this.Points.get(i+1);//titik yang akan dibandingkan dengan titik terkecil
            //kondisi jika titik yang dicek lebih kecil koordinat x dan y nya dari titik terkecil
            if(cek.x<titikTerkecil.x && cek.y<titikTerkecil.y){
                titikTerkecil = cek; //update atau ganti titik terkecil dengan titik yang dicek
            }
        }
        
        return titikTerkecil; //return titik yang memiliki koordinat x dan y paling kecil 
    }
    
    

   
    
        
    
}
class sort implements Comparator<MyPoint>{
    
    public int compare(MyPoint q1, MyPoint q2) //membandingkan sudut kedua titik
    {

        MyPointSet set = new MyPointSet(); //instansiasi point set(kumpulan titik)
        //sorting titik berdasarkan sudut 
        MyPoint p = set.carititikTerkecil(); //set p dengan titik yang koordinat x dan y yang paling kecil
        int angle1 = (int)p.angleTo(q1); //mencari sudut titik pertama
        int angle2 = (int)p.angleTo(q2); //mencari sudut titik kedua
        //sumber : https://www.sanfoundry.com/java-program-implement-graham-scan-algorithm-find-convex-hull/
        return angle2-angle1;
    }


}