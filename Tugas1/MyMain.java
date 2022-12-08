//@author Doni Andrian - 6182001020
//		  Kevin Jonathan - 6182001026

import java.util.Scanner;

import java.util.Collections;

public class MyMain {
    
    //TULISKAN KOMENTAR UNTUK SETIAP BARIS YANG ANDA BUAT!!!
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner
		int ch = sc.nextInt();				// pilihan fungsi atau keluar
		while(ch!=0) {					//selama tidak memilih keluar
			if (1==ch) { //fungsi 1
				MyPoint A = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik pertama
				MyPoint B = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik kedua
				System.out.printf("%.3f",A.distanceToOtherPoints(B)); //output jarak titik pertama dan titik kedua
				System.out.println();
			}
			else if (2==ch) { //fungsi 2
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik pertama
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik kedua
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik ketiga

				
				MyLineSegment l = new MyLineSegment(q,r); //instansiasi segmen garis
				double hasil = p.distanceToLineSegment(l);//mendapatkan hasil dengan cara memanggil method untuk mencari jarak dari segmen garis ke titik  
				 

				System.out.printf("%.3f",hasil ); //output hasil
				System.out.println();


			}
			else if (3==ch) { //fungsi 3
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik pertama
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik kedua
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik ketiga
				MyLineSegment l = new MyLineSegment(p,q); //segmen garis/vektor dari p ke q
				double res = l.leftTurnToPoint(r); // dari p ke q ke r apakah belok kiri/kanan/lurus
				String arah = new String("Kolinear"); //instansiasi string arah
				if (res<0.0) arah = "Kanan"; //kondisi jika posisi titik terhadap segmen garis belok kanan 
				else if (res>0.0) arah = "Kiri"; //kondisi jika posisi titik terhadap segmen garis belok kiri
				System.out.println(arah); //output posisi titik terhadap segmen garis
			}
			else if (4==ch) { //fungsi 4
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik pertama
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik kedua
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik ketiga
				MyPoint s = new MyPoint(sc.nextDouble(),sc.nextDouble()); //instansiasi titik keempat
				MyLineSegment l = new MyLineSegment(p,q); //instansiasi segmen garis pertama dari titik pertama dan titik kedua
				MyLineSegment m = new MyLineSegment(r,s); //instansiasi segmen garis kedua dari titik ketiga dan titik keempat
				boolean intersect = l.isIntersect(m); //menentukan berpotongan atau tidak berpotongan dengan memanggil method isIntersect untuk segmen garis pertama dan kedua

				//kondisi jika kedua segmen garis tidak berpotongan
				if(intersect == false){
					System.out.println("Tidak"); //output tidak berpotongan
				}
				//kondisi jika kedua segmen garis berpotongan
				else{
					System.out.println("Ya"); //output ya(berpotongan)
				}

				
				

			}
			else if (5==ch) { // fungsi 5
				int n = sc.nextInt();
				MyPolygon poly = new MyPolygon();
				

				//memasukkan poin-point yang membentuk polygon ke dalam arraylist
				for (int i = 0;i<n;i++){
					MyPoint p = new MyPoint (sc.nextDouble(),sc.nextDouble());
					poly.addPoint(p);

				}
				boolean hasil = poly.isConvex(); 

				if (hasil == true){ //kondisi saat semua segmen garis berbelok ke kiri 
					System.out.println("Convex");

				}else{
					System.out.println("Concave");//kondisi saat segmen garis ada yang berbelok ke kanan
				}
		



			}
			else if (6==ch) {
				int n = sc.nextInt(); //input banyaknya titik
				MyPolygon poly = new MyPolygon(); //instansiasi simple polygon

				//looping input titik dan memasukan seluruh input titik ke array list polygon 
				for(int i = 0;i<n;i++){
					MyPoint p = new MyPoint(sc.nextDouble(), sc.nextDouble()); //input titik
					poly.addPoint(p); //memasukan input titik ke array list polygon
				}
				
				
				System.out.printf("%.3f",poly.area()); //output area polygon
				System.out.println();

			}
			else if (7==ch) { //fungsi 7
				int n = sc.nextInt(); //input banyaknya titik
				MyPolygon poly = new MyPolygon(); //instansiasi polygon
				//looping memasukan semua titik ke dalam arraylist polygon 
				for (int i = 0;i<n;i++){
					MyPoint p = new MyPoint (sc.nextDouble(),sc.nextDouble()); //input titik
					poly.addPoint(p); //memasukan titik ke dalam arraylist polygon

				}
				MyPoint A = new MyPoint(sc.nextDouble(),sc.nextDouble()); //input titik yang akan diperiksa

				boolean hasil = poly.isPointInside(A); //menentukan titik ada di dalam atau di luar polygon
				//kondisi jika titik ada di dalam polygon
				if(hasil == true){
					System.out.println("In"); //output in

				}else{//kondisi jika titik ada di luar polygon
					System.out.println("Out"); //output out
				}
			}
			
			else if (8==ch) {
				int n = sc.nextInt(); //input banyaknya titik
				MyPointSet mps = new MyPointSet(); //instansiasi kumpulan titik(point set)

				//looping memasukan semua titik ke array list point set
				for(int i = 0;i<n;i++){
					MyPoint p = new MyPoint (sc.nextDouble(),sc.nextDouble()); //input titik
					mps.addPoint(p); //memasukan titik ke array list point set
				}

				//sortingnya masih error
				Collections.sort(mps.Points,new sort());

				//looping print titik yang telah di sort
				for(int i = 0;i<mps.Points.size();i++){
					System.out.println(mps.Points.get(i));
				}
				
				
				
			}			
			ch = sc.nextInt();				// pilihan berikutnya
		}			
        //System.out.println(CG.ccw(p,q,t));
    }
}

/*
Implementasikan fungsi-fungsi untuk menghitung:
1. Jarak antara 2 buah titik
2. Jarak sebuah titik ke sebuah segmen garis
3. Posisi sebuah titik terhadap sebuah segmen garis (kiri, kanan, atau lurus/colinear)
4. Apakah dua buah segmen garis saling berpotongan?
Jika titik pada satu segmen menyentuh segmen/titik ujung dari segmen yang lain, maka dianggap berpotongan
5. Apakah sebuah simple polygon itu convex atau concave
6. Menghitung luas simple polygon
7. Apakah sebuah titik berada di dalam atau di luar sebuah simple polygon?
Jika titik berimpitan dengan poligon/terletak pada sisi poligon, maka dianggap di dalam
8. Diberikan kumpulan titik di R2, urutkan secara menaik berdasarkan sudut dengan titik paling kiri bawah.

Input terdiri dari beberapa tes kasus.
Untuk setiap tes kasus, sebuah bilangan n menunjukkan nomor fungsi (di atas) yang hendak diuji.
Kemudian, diberikan sejumlah nilai sesuai dengan fungsi tersebut:
1. Dua buah titik p dan q yang dinyatakan dengan 4 buah integer beurutan x1, y1, x2, dan y2, dimana p=(x1,y1) dan q=(x2,y2) 
2. Sebuah titik p dan sebuah segmen garis (terdiri dari dua buah titik q dan r) yang dinyatakan dengan 6 buah integer berurutan x1, y1, x2, y2, x3, dan y3 dimana p=(x1,y1), q =(x2,y2), dan r =(x3,y3)
3. Sama dengan nomor 2, segmen garis berarah dari q menuju r
4. Empat buah titik p, q, r, dan s yang merupakan titik ujung dari dua segmen garis l1={p,q} dan l2={r,s} yang dinyatakan dengan 8 buah integer berurutan x1,y1,x2,y2,x3,y3,x4, dan y4 dimana p=(x1,y1), q=(x2,y2), r=(x3,y3) dan s=(x4,y4) 
5. Sebuah bilangan n>=3 yang menyatakan banyaknya titik pada poligon, diikuti dengan x buah titik yang koordinat-koordinatnya dinyatakan dengan dua buah bilangan x_i dan y_i. 
6. Sama dengan no 5
7. Sama dengan no 5, tetapi ditambah dengan dua buah bilangan x dan y yang menyatakan koordinat sebuah titik
8. Sama dengan no 5
Input diakhiri jika n=0

Spesifikasi output:
Sesuai dengan tes kasus yang diberikan, tampilkan untuk setiap fungsi:
1. Jarak dengan ketepatan 3 angka di belakang koma
2. Jarak dengan ketepatan 3 angka di belakang koma
3. "Kiri", "Kanan", atau "Kolinear"
4. "Ya" jika berpotongan atau "Tidak" jika tidak
5. "Convex" jika convex atau "Concave" jika concave
6. Luas poligon dengan ketepatan 3 angka di belakang koma
7. "In" jika di dalam atau "Out" jika di luar
8. Bilangan n diikuti dengan n buah titik (dinyatakan dalam koordinat x dan y pisahkan dengan spasi) satu titik dalam tiap baris

Contoh input-output
CONTOH INPUT
1			==>input, kasus pertama, menguji fungsi ke-1
0 0 3 3  		==>input data untuk kasus pertama
2        		==>input, kasus kedua, menguji fungsi ke-2
c	==> input data untuk kasus kedua 
3
1 1 0 0 -10 0
4
50 20 76 -12 4 8 92 32
5		==> input, kasus kelima, menguji fungsi ke-5
4		==> poligon terdiri dari 4 buah titik
2 -3 	==> titik pertama dari poligon
4 8 		==> titik kedua dari poligon
-3 3 	==> titik ketiga
-7 1 	==> titik keempat. Jadi poligon: (2,-3),(4,8)(-3,3)(-7,1), titik2nya sudah terurut berlawanan arah jarum jam
6		==> kasus 6
4		==> poligon terdiri dari 4 buah titik, sudah terurut berlawanan arah jarum jam		
2 -3 
4 8 
-3 3 
-7 1
7		==> input, kasus ketujuh, menguji fungsi ke-7
4		==> poligon terdiri dari 4 buah titik, sudah terurut berlawanan arah jarum jam
2 -3		
4 8
-3 3
-7 1  
0 0 		==> koordinat titik yang akan diperiksa apakah ada di dalam atau di luar
8		==> input, kasus kedelapan, menguji fungsi ke-8					
5		==> n=banyak titik. Himpunan terdiri dari 5 titik, tidak ada keterurutan tertentu
4 7		==> titik pertama
10 1		==> titik kedua
0 0
1 4
7 3
0		==> akhir input

CONTOH OUTPUT
4.243 	==>output kasus pertama
1.414	==>output kasus kedua
Kanan	==>output kasus ketiga
Ya 		==>output kasus keempat
Concave	==>output kasus kelima
50.500	==>output kasus keenam
In		==>output kasus ketujuh
5		==>output kasus kedelapan, ada 5 titik yang memiliki keterurutan tertentu
0 0		==> titik paling kiri bawah
10 1
7 3
4 7
1 4		
 * 
 */
