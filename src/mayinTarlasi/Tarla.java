package mayinTarlasi;

import java.awt.Graphics;
import mayinTarlasi.Mayin;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tarla implements TarlaOzellikleri{
        
        private Mayin[][] butonlar;
        int satir = 0;
        int sutun = 0;
        
        private String[][] mayin;
        int satSayi = 0;
        int sutSayi = 0;
        
        Mayin myn = new Mayin();
        
        public String[][] getMayin() {
            return mayin;
        }

        public void setMayin(String[][] mayin) {
            this.mayin = mayin;
        }
        
        public Mayin[][] getButonlar() {
            return butonlar;
        }

        public void setButonlar(Mayin[][] butonlar) {
            this.butonlar = butonlar;
        }
    
        public void mayinDose(int satirSayisi, int sutunSayisi, int mayinSayisi)//buton sayısına denk sekilde iki boyutlu bir dizi yapıldı
        {    
             satSayi = satirSayisi;
             sutSayi = sutunSayisi;
             setMayin(new String[satirSayisi][sutunSayisi]);//mayinlar icin yeni dizi yapildi

             for( int i=0; i<satirSayisi; i++ )
                 for( int j=0; j<sutunSayisi; j++ )
                      getMayin()[i][j] = "temiz";



           for(int j=0; j<mayinSayisi; j++)// rasgtele yerlere mayin dösendi
           {
             int sayi1 = (int)(Math.random()*(satirSayisi-1));
             int sayi2 = (int)(Math.random()*(sutunSayisi-1));

               getMayin()[sayi1][sayi2] = "Mayin";

           }
           
           for( int i=0; i<satirSayisi; i++ )
                 for( int j=0; j<sutunSayisi; j++ ){
                     if(getMayin()[i][j].equals("Mayin"))
                         continue;
                     getMayin()[i][j] = ""+mayinSay(i, j);
                 }
                      

        }
        
        public int mayinSay(int gelenSat,int gelenSut)//tıklanan butonun etrafında kac adet mayin var sayilir
        {
            int sayac = 0;

            for(int i = gelenSat-1 ; i <=gelenSat+1 ; i++ ){
                
                 if(i < 0)
                     i = 0;
                 if(i >= satSayi)
                        break; 
                 for(int j = gelenSut-1 ; j <=gelenSut+1 ; j++ )
                 {
                     if(j < 0)
                        j = 0;
                     if(j >= sutSayi)
                           break;
                     if(mayin[i][j].equals("Mayin"))
                         sayac++;
                 }
            }

            return sayac;
        }
    
        MouseListener listener[][];
        
        public void yerlestir(final int satirSayisi,final int sutunSayisi){
            
            setButonlar(new Mayin[satirSayisi][sutunSayisi]);  
            listener = new MouseListener[satirSayisi][sutunSayisi];
            
            for(int i = 0 ; i<satirSayisi; i++) {
                for(int j = 0; j <sutunSayisi ;j++){

                    getButonlar()[i][j] = new Mayin();
                    getButonlar()[i][j].setName("buton " + i + " " + j);
                    getButonlar()[i][j].setLocation((j)*30, (i+1)*30);
                    getButonlar()[i][j].setSize(30,30);
                    //getButonlar()[i][j].setOpaque(true);
                    //getButonlar()[i][j].setBackground(Color.white);
                    //Font f =(new Font("1", Font.ROMAN_BASELINE,8));
                    //getButonlar()[i][j].setFont(f);

                    
                    listener[i][j] = new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                              String[] a = e.toString().split(" ");
                              satir = Integer.parseInt(a[3]); //basilan butonun satir numarasi alindi
                              sutun = Integer.parseInt(a[4]); //basilan butonun sutun numarasi alindi

                              if( !(getMayin()[satir][sutun].equals("Mayin")) ){
                                  getMayin()[satir][sutun] = "acik";
                              }   

                               if(e.getButton() == MouseEvent.BUTTON3) // butona sağ mı tiklandi diye kontrol edildi
                               {

                                    getButonlar()[satir][sutun].setText("");
                                    getButonlar()[satir][sutun].setIcon(myn.resim);
                                    getButonlar()[satir][sutun].setBackground(Color.white);
                               }

                               else
                               {   
                                    getButonlar()[satir][sutun].setIcon(null);

                                    if(getMayin()[satir][sutun].equals("Mayin")) 
                                    {
                                          patlat();
                                    }
                                    else
                                    {       
                                          int gelen = 0;
                                          gelen = mayinSay(satir,sutun);
                                          getButonlar()[satir][sutun].setBackground(Color.white);
                                          getButonlar()[satir][sutun].setForeground(myn.renk(gelen));
                                          
                                          if(gelen!=0)
                                              getButonlar()[satir][sutun].setText(String.valueOf(gelen));
                                          
                                          

                                          if(gelen==0)
                                              mayinAc(satir, sutun);
                                    }
                                }
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    };
                    
                    getButonlar()[i][j].addMouseListener(listener[i][j]);
                }
            }        
         
       }
 
        public void mayinAc(int gelenSat,int gelenSut){
            
            for(int i = gelenSat-1 ; i <=gelenSat+1 ; i++ ){    
                 if(i<0)
                     i = 0;
                 if(i >= satSayi)
                        break; 
                 for(int j = gelenSut-1 ; j <=gelenSut+1 ; j++ ){
                     if(j < 0)
                        j = 0;
                     if(j>=sutSayi)
                           break;

                     getButonlar()[i][j].setBackground(Color.white);
                     if(mayinSay(i, j) != 0){
                         getButonlar()[i][j].setText(String.valueOf(mayinSay(i, j))); 
                         getButonlar()[i][j].setForeground(myn.renk(mayinSay(i, j)));
                     }
                        

                     if(i==gelenSat && j==gelenSut)
                         continue;

                     if(mayin[i][j].equals("0") && !(getMayin()[i][j].equals("Mayin")) ){
                         getMayin()[i][j] = "acik";
                         getButonlar()[i][j].setEnabled(false);
                         mayinAc(i, j);   
                     }
                 }
            }

        }
     
        public void patlat(){
            
             for(int i = 0 ; i <satSayi; i++ ){  
                 for(int j = 0 ; j <sutSayi ; j++ ){
                     
                     getButonlar()[i][j].removeMouseListener(listener[i][j]);
                     
                    if(getMayin()[i][j].equals("Mayin")){
                        getButonlar()[i][j].setBackground(Color.white);
                        getButonlar()[i][j].setForeground(myn.renk(mayinSay(i, j)));
                        getButonlar()[i][j].setIcon(myn.resim2);
                    }
                    else{
                          getButonlar()[i][j].setEnabled(false);
                    }

                 }
            }

        }

   
     
}
