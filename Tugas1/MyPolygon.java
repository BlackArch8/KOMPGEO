import java.util.ArrayList;
import java.util.List;

public class MyPolygon {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * @return
     */
    public MyPolygon() {
        this.Points = new ArrayList<MyPoint>(); //instansiasi array list untuk menampung seluruh titik polygon
    }

    /**
     * [5a,6a,7a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p); //memasukan titik ke array list
        return true;
    }

    /**
     * [5b] konveks ato bukan
     * @return
     */
    boolean isConvex() {
		boolean convex = true;//return true jika semua nya berbelok ke kiri
        //cek setiap segmen garis 
        for(int i = 0;i<Points.size();i++){


            double res = 0.0; //insialisasi variabel res(hasil)
            //gunakan cross product untuk mencari apakah belok kiri atau belok kanan(kondisi nya adalah berlawanan arah jarum jam)
            res = CG.ccw(this.Points.get(i % this.Points.size()) , this.Points.get((i+1) % this.Points.size()), this.Points.get((i+2) % this.Points.size()));
            //jika res < 0 maka berbelok ke kanan
			if (res<0.0){//jika belok kanan maka maka polygon tersebut concave
                convex = false;
                return convex;

            }  

        

        }
        
		

		
        return convex;
    }

    /**
     * [6b] luas poligon ini
     * @return
     */
    double area() {

		double area = 0.0; //inisialisasi
        //looping titik yang membentuk segitiga di polygon	
		for(int i = 0;i<this.Points.size()-2;i++){
            //bagi sebuah polygon menjadi segitiga-segitiga untuk dicari luasnya
             MyTriangle T = new MyTriangle(this.Points.get(0),this.Points.get(i+1),this.Points.get(i+2));
            area += T.area(); //gabungkan luas segitiganya
        }
				
			
				
		
        return area; //output gabungan dari luas segitiga-segitiga yang merupakan luas polygon
    }

    /**
     * [7b] titik p di dalem ato luar,
     * jika berimpitan dengan titik atau segmen, di dalam 
     * @param p
     * @return
     */
    boolean isPointInside(MyPoint p) {
		boolean inside = true; //inisialisasi true jika semua segmen berbelok ke kiri terhadap titik p
        //cek setiap segmennya
        for(int i = 0;i<Points.size();i++){


            double res = 0.0; //inisialisasi variabel res(hasil)
            //gunakan cross product untuk mencari apakah belok kiri atau belok kanan(kondisi nya adalah berlawanan arah jarum jam)
            res = CG.ccw(this.Points.get(i), this.Points.get((i+1) % this.Points.size()), p);
			if (res<0.0){
                inside = false; //return false jika  res = minus yang artinya belok kanan. Berarti titiknya ada diluar 
                return inside;

            }  

        }
		//return true jika titik p di ada dalam atau berimpitan 
        return inside;
    }

}
