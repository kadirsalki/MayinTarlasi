package mayinTarlasi;


import java.awt.Color;
import java.awt.Insets;
import java.awt.MenuComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicBorders;
import javax.xml.transform.Source;


public class Mayin extends JButton {
    
        public Mayin(){
            super.setMargin(new Insets(0, 0, 0, 0));
            super.setBackground(Color.darkGray);
            super.setOpaque(true);
        }

        URL dosyaYolu = getClass().getResource("/resimler/bayrak.png");
        ImageIcon resim = new ImageIcon(dosyaYolu);
        
        URL dosyaYolu2 = getClass().getResource("/resimler/Mayin.png");
        ImageIcon resim2 = new ImageIcon(dosyaYolu2);
     
        public Color renk(int renkSayi){ //mayin sayilarini renklendirmek icin..
            if(renkSayi == 1)
                return Color.blue;
            else if(renkSayi == 2)
                return new Color(0, 100, 0);
            else if(renkSayi == 3)
                return Color.RED;
            else if(renkSayi == 4)
                return Color.ORANGE;
            else if(renkSayi == 5)
                return Color.magenta;
            else if(renkSayi == 6)
                return Color.cyan;
            else if(renkSayi == 7)
                return Color.YELLOW;
            else 
                return Color.BLACK;
            
        }

}


    
    
    
    
    

