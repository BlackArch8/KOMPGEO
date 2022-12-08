import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyPointSet  {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [8a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p);
        return true;
    }
    List getPoints() {
        return this.Points;
    }

    public MyPoint carititikTerkecil(){
        MyPoint titikTerkecil = this.Points.get(0); //set titik paling kecil dengan titik pada arraylist index 0
        //looping array list untuk mencari titik terkecil
        for(int i = 0;i<this.Points.size()-1;i++){
            MyPoint cek = this.Points.get(i+1);//titik yang akan dibandingkan dengan titik terkecil
            //kondisi jika 
            if(cek.x<titikTerkecil.x && cek.y<titikTerkecil.y){
                titikTerkecil = cek;
            }
        }
        return titikTerkecil;
    }
    

    //sumber: https://stackoverflow.com/questions/54170381/sorting-by-polar-angle
		
    



    @Override
    public int compareTo(MyPointSet o) {
        double cr = CG.cross(Points.get(i).x - carititikTerkecil().x , (Points.get(i)).y - carititikTerkecil().y ,Points.get(i+1).y - carititikTerkecil().y, Points.get(i+1).y - carititikTerkecil().y);
        if(cr>0){
            return 1;
        }else{
            return -1;
        }
        
        return 0;
    }

    
    
    }
    