package test;


import mayinTarlasi.Mayin;
import mayinTarlasi.Tarla;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class MayinTarlasi extends javax.swing.JFrame {

    Tarla tarla = new Tarla();
    Mayin m = new Mayin();
    
    public MayinTarlasi()
    {   
        initComponents();
        
        jButton1.setIcon(resim);
        this.setLocationRelativeTo(null);
    }

    URL dosyaYolu = getClass().getResource("/resimler/yuz.jpg");
    ImageIcon resim = new ImageIcon(dosyaYolu);  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        kolay = new javax.swing.JMenuItem();
        orta = new javax.swing.JMenuItem();
        zor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Oyun");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N

        kolay.setText("Kolay (10x10)");
        kolay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolayActionPerformed(evt);
            }
        });
        jMenu1.add(kolay);

        orta.setText("Orta (16x16)");
        orta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ortaActionPerformed(evt);
            }
        });
        jMenu1.add(orta);

        zor.setText("Zor (16x30)");
        zor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zorActionPerformed(evt);
            }
        });
        jMenu1.add(zor);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int sayac = 0;//yeni oyun dendiğinde timr a bir kez girilmesini kontrol eder
    
    public void baslama(int gelenSatir, int gelenSutun, int gelenMayin){
        zaman = 0;//label a yazilan zamanı sırıfladık
        satir = gelenSatir;
        sutun = gelenSutun;
        mayin = gelenMayin;
        tarla.mayinDose(satir,sutun,mayin);
        getir();
        this.revalidate();  
        this.setSize(sutun*30+5, satir*30+65+jMenuBar1.getHeight()+jPanel3.getHeight());
        this.setResizable(false);
    }
    private void kolayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolayActionPerformed
        baslama(10,10,10);
        
    }//GEN-LAST:event_kolayActionPerformed

    private void ortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ortaActionPerformed
       baslama(16,16,40);
    }//GEN-LAST:event_ortaActionPerformed

    private void zorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zorActionPerformed
        baslama(16, 30,100);
    }//GEN-LAST:event_zorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(satir!=0 && sutun!=0)
            baslama(satir, sutun, mayin);
    }//GEN-LAST:event_jButton1ActionPerformed

    int kontrol = 0;//kullanıcının yeni oyunu tıklamasını kontrol eder

    int satir = 0,sutun = 0;
    int mayin = 0;
    public void getir(){
        
        if(kontrol==1)//kullanıcı yeni oyunu secerse ekrandakiler silindi 
        {
              kontrol=0;
              jPanel1.removeAll();
        }

         tarla.yerlestir(satir,sutun);

         for(int j = 0 ; j < satir ; j++)//butonlar panele yerlestirildi
         {  
             for(int i = 0 ; i < sutun; i++)
             {
                 
                  jPanel1.add(tarla.getButonlar()[j][i]);
             }
         }
         
         jPanel1.repaint();
         
         kontrol = 1; 
         //jPanel1.setLayout(new GridLayout(satir, sutun));//panele layout eklenerek ekran bölündüqq

         if(sayac<1)//tekrar yeni oyun dendiğinde zaman sıfırlanır ve tekrar timer çalıştırılmaz
         {   
              time();//timer methodu çağırıldı
              sayac++;
         }
    }
    
    int zaman = 0;
    public void time(){
        javax.swing.Timer  t = new javax.swing.Timer(1000, new ActionListener() {
                

            public void actionPerformed(ActionEvent e) {
                zaman++;
                jLabel1.setText( String.valueOf("Süre:" + zaman) );
                //jLabel1.setIcon(resim);
                
             }
        
        }); t.start();
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MayinTarlasi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem kolay;
    private javax.swing.JMenuItem orta;
    private javax.swing.JMenuItem zor;
    // End of variables declaration//GEN-END:variables
}
