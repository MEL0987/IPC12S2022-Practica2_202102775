
package snake1.pkg1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Snake1 extends javax.swing.JFrame implements KeyListener, Runnable{

    int snake = -1;
    boolean valido=true, activado=false, co=false;
    int direccion, puntos=0, contador;
    Point ultimo;
    int x,y;
        
    //Para el timer con hilo
     String minutos;
     String horas;
     String segundos;
     String ampm;
     Calendar calendario;
     //Hilo
     Thread h1;
     
     
     //Para los movimiento
     int cantidad_ar;
     int cantidad_ab;
     int cantidad_iz;
     int cantidad_de;
     
     String Facil;
     String Medio;
     String Dificil;
     
        
    public Snake1() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        h1 = new Thread(this);
        h1.start();
        setSize(530,650);
        do {            
            x=(int)Math.floor(Math.random()*23);
            y=(int)Math.floor(Math.random()*23);
            valido=false;
            
            
            
        } while (valido);
        jPanel1.setBounds(0, 0, 530, 650);
        JButton cabeza = new JButton();
        List<JButton> serp=new ArrayList<>();
        List<Point> PartesSerp=new ArrayList<>();
        cabeza.setBounds(x*20, y*20,20, 20);
        cabeza.setContentAreaFilled(false);
        cabeza.setOpaque(true);
        cabeza.setBackground(Color.YELLOW);
        cabeza.addKeyListener(this);
        
        jPanel1.add(cabeza);
        
        JButton comida = new JButton();
        comida.setBounds(x*20, y*20,20, 20);
        comida.setContentAreaFilled(false);
        comida.setOpaque(true);
        comida.setBackground(Color.RED);
        comida.addKeyListener(this);
        jPanel1.add(comida);
        jPanel1.addKeyListener(this);
        
        
         Timer  p = new Timer();
        
        TimerTask movimiento =new TimerTask() {
            @Override
            public void run() {
                co=false;
                contador=0;
                jLabel1.setText("Puntos: " +puntos);
                PartesSerp.add(cabeza.getLocation());
                activado=false;
                int tamaño=PartesSerp.size();
                for (int i = 0; i <=tamaño-1; i++) {
                    if (PartesSerp.size()==serp.size()) {
                        break;
                    }
                    
                    PartesSerp.remove(0);
                    
                }
                
                switch(direccion){
                    case 1:
                    cabeza.setLocation(cabeza.getX()+20, cabeza.getY());
                    if (cabeza.getX()>=comida.getX()&cabeza.getX()<=comida.getX()+20) {
                        if (cabeza.getY()>=comida.getY()&cabeza.getY()<=comida.getY()+20) {
                            PartesSerp.add(cabeza.getLocation());
                            serp.add(new JButton());
                            snake++;
                            serp.get(snake).setContentAreaFilled(false);
                            serp.get(snake).setOpaque(true);
                            serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake),new Dimension(20,20)));
                            serp.get(snake).setBackground(Color.ORANGE);
                            jPanel1.add(serp.get(snake));
                            
                            
                            do {                                
                                for (int e = 0; e<=serp.size()-1; e++){
                                    x=(int)Math.floor(Math.random()*23);
                                    y=(int)Math.floor(Math.random()*23);
                                    
                                    valido=(new Point(x*20, y*20).equals(serp.get(e).getLocation()));
                                    if(!valido)break;
                                }
                }while (valido);
                            comida.setLocation(x*20, y*20);
                            puntos++;
                            co=true;
                            
                   }       
            } 
                    break;
                    
                    case 2:
                    cabeza.setLocation(cabeza.getX()-20, cabeza.getY());
                    if (cabeza.getX()>=comida.getX()&cabeza.getX()<=comida.getX()+20) {
                        if (cabeza.getY()>=comida.getY()&cabeza.getY()<=comida.getY()+20) {
                            PartesSerp.add(cabeza.getLocation());
                            serp.add(new JButton());
                            snake++;
                            serp.get(snake).setContentAreaFilled(false);
                            serp.get(snake).setOpaque(true);
                            serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake),new Dimension(20,20)));
                            serp.get(snake).setBackground(Color.ORANGE);
                            jPanel1.add(serp.get(snake));
                            
                            
                            do {                                
                                for (int e = 0; e<=serp.size()-1; e++){
                                    x=(int)Math.floor(Math.random()*23);
                                    y=(int)Math.floor(Math.random()*23);
                                    
                                    valido=(new Point(x*20, y*20).equals(serp.get(e).getLocation()));
                                    if(!valido)break;
                                }
                }while (valido);
                            comida.setLocation(x*20, y*20);
                            puntos++;
                            co=true;
                   }       
            } 
                    break;
                
                    case 3:
                    cabeza.setLocation(cabeza.getX(), cabeza.getY()+20);
                    if (cabeza.getX()>=comida.getX()&cabeza.getX()<=comida.getX()+20) {
                        if (cabeza.getY()>=comida.getY()&cabeza.getY()<=comida.getY()+20) {
                            PartesSerp.add(cabeza.getLocation());
                            serp.add(new JButton());
                            snake++;
                            serp.get(snake).setContentAreaFilled(false);
                            serp.get(snake).setOpaque(true);
                            serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake),new Dimension(20,20)));
                            serp.get(snake).setBackground(Color.ORANGE);
                            jPanel1.add(serp.get(snake));
                            
                            
                            do {                                
                                for (int e = 0; e<=serp.size()-1; e++){
                                    x=(int)Math.floor(Math.random()*23);
                                    y=(int)Math.floor(Math.random()*23);
                                    
                                    valido=(new Point(x*20, y*20).equals(serp.get(e).getLocation()));
                                    if(!valido)break;
                                }
                }while (valido);
                            comida.setLocation(x*20, y*20);
                            puntos++;
                            co=true;
                   }       
            } 
                    break;
                    case 4:
                    cabeza.setLocation(cabeza.getX(), cabeza.getY()-20);
                    if (cabeza.getX()>=comida.getX()&cabeza.getX()<=comida.getX()+20) {
                        if (cabeza.getY()>=comida.getY()&cabeza.getY()<=comida.getY()+20) {
                            PartesSerp.add(cabeza.getLocation());
                            serp.add(new JButton());
                            snake++;
                            serp.get(snake).setContentAreaFilled(false);
                            serp.get(snake).setOpaque(true);
                            serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake),new Dimension(20,20)));
                            serp.get(snake).setBackground(Color.ORANGE);
                            jPanel1.add(serp.get(snake));
                            
                            
                            do {                                
                                for (int e = 0; e<=serp.size()-1; e++){
                                    x=(int)Math.floor(Math.random()*23);
                                    y=(int)Math.floor(Math.random()*23);
                                    
                                    valido=(new Point(x*20, y*20).equals(serp.get(e).getLocation()));
                                    if(!valido)break;
                                }
                }while (valido);
                            comida.setLocation(x*20, y*20);
                            puntos++;
                            co=true;
                   }       
                } 
                    break;
                  }  
                
                for (int i = 0; i <=PartesSerp.size()-1 ; i++) {
                
                    if(cabeza.getLocation().equals(PartesSerp.get(i))){
                         
                                
                        
                        contador++;
                        System.out.println("contador");
                        
                        if (co) {
                            if (contador==2) {
                                JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son" +puntos);
                                GenerarHTML();
                                System.exit(0);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Perdiste, Tus puntos Son: "+puntos);
                            GenerarHTML();
                            System.exit(0);
                        }
                    }
                }
                
                for (int i = 0; i <=serp.size()-1; i++) {
                    
                    serp.get(i).setLocation(PartesSerp.get(i));
                    
                }
                if (cabeza.getLocation().getX()>=500) {
                    JOptionPane.showMessageDialog(null, "Perdiste, Tus puntos Son: "+puntos);
                    GenerarHTML();
                    
                    System.exit(0);
                    
                }
                if (cabeza.getLocation().getY()>=500) {
                    JOptionPane.showMessageDialog(null, "Perdiste, Tus puntos Son: "+puntos);
                    GenerarHTML();
                    System.exit(0);
                }
                if (cabeza.getLocation().getX()<0) {
                    JOptionPane.showMessageDialog(null, "Perdiste, Tus puntos Son: "+puntos);
                    GenerarHTML();
                    System.exit(0);
                }
                if (cabeza.getLocation().getY()<0) {
                    JOptionPane.showMessageDialog(null, "Perdiste, Tus puntos Son: "+puntos);
                    GenerarHTML();
                    System.exit(0);
                }
                if (puntos==25) {
                        JOptionPane.showMessageDialog(null, "Ganaste, tus puntos son: " +puntos);
                        GenerarHTML();
                        System.exit(0);
                    
                }
                
               } 
             
        
          };
        
        
       p.schedule(movimiento, 0, 75);
       
    }
    
@Override
    public Image getIconImage (){
        
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imgs/s1.png"));
        
       return retValue;
    }
    

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        facil = new javax.swing.JButton();
        medio = new javax.swing.JButton();
        dificil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ti = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        difi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNAKE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel1.setText("Puntos: ");

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        facil.setBackground(new java.awt.Color(153, 255, 255));
        facil.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        facil.setText("Facil");
        facil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                facilMousePressed(evt);
            }
        });
        facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilActionPerformed(evt);
            }
        });

        medio.setBackground(new java.awt.Color(153, 255, 255));
        medio.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        medio.setText("Medio");
        medio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                medioMousePressed(evt);
            }
        });
        medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medioActionPerformed(evt);
            }
        });

        dificil.setBackground(new java.awt.Color(153, 255, 255));
        dificil.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        dificil.setText("Dificil");
        dificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dificilMousePressed(evt);
            }
        });
        dificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dificilActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jLabel2.setText("Tiempo:");

        ti.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        ti.setText("00:00:00:00");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/apple.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/chronometer.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/serpent.png"))); // NOI18N

        difi.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        difi.setText("Dificultad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ti, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(facil)
                        .addGap(18, 18, 18)
                        .addComponent(medio)
                        .addGap(18, 18, 18)
                        .addComponent(dificil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(difi)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(ti)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(facil)
                            .addComponent(medio)
                            .addComponent(dificil)
                            .addComponent(jLabel1)
                            .addComponent(difi))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        JOptionPane.showMessageDialog(null,"Seleecione dificultad para comenzar");
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private void facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilActionPerformed
        
        facil.setEnabled(false);
        medio.setEnabled(false);
        dificil.setEnabled(false);
        difi.setText("Dificultad: " +Facil);
        
        
        
        
    }//GEN-LAST:event_facilActionPerformed

    private void facilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facilMousePressed
        Facil="Facil";
        Medio="_____";
        Dificil="_____";
    }//GEN-LAST:event_facilMousePressed

    private void medioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medioMousePressed
        Medio="Media";
        Facil="_____";
        Dificil="_____";
    }//GEN-LAST:event_medioMousePressed

    private void medioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medioActionPerformed
        facil.setEnabled(false);
        medio.setEnabled(false);
        dificil.setEnabled(false);
        difi.setText("Dificultad: " +Medio);
    }//GEN-LAST:event_medioActionPerformed

    private void dificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dificilActionPerformed
        facil.setEnabled(false);
        medio.setEnabled(false);
        dificil.setEnabled(false);
        difi.setText("Dificultad: " +Dificil);
    }//GEN-LAST:event_dificilActionPerformed

    private void dificilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dificilMousePressed
        Dificil="Dificil";
        Facil="_____";
        Medio="_____";
    }//GEN-LAST:event_dificilMousePressed
/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Snake1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Snake1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Snake1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Snake1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Snake1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel difi;
    private javax.swing.JButton dificil;
    private javax.swing.JButton facil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton medio;
    private javax.swing.JLabel ti;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Presiona");
        if(e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("Arriba: " +cantidad_ar);
            //Contador de movimientos
            cantidad_ar++;
            
            if(direccion!=3)
                direccion=4;
                //ARRIBA
            }
            if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                System.out.println("Abajo: " +cantidad_ab);
                //Contador de movimientos
                cantidad_ab++;
                
                if (direccion!=4) 
                    direccion=3;
                    //ABAJO
                }
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    System.out.println("Izquierda: " +cantidad_iz);
                    //Contador de movimientos
                    cantidad_iz++;
                    
                    if (direccion!=1) 
                        direccion=2;
                        //IZQUIERDA
                    }
                    if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
                        System.out.println("Derecha: " +cantidad_de);
                        //Contador de movimientos
                        cantidad_de++;
                        
                        if (direccion!=2) 
                            direccion=1;
                            //DERECHA
                        }
                    }
  
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    //Generador
    
    public  void GenerarHTML() {
        FileWriter fichero=null;
        PrintWriter pw = null;
         
        //Try catch
        
        try {
            fichero = new FileWriter("202102775.html");
            pw = new PrintWriter(fichero);
            
            pw.println("<HTML>");
            pw.println("<body>");
            pw.println("<font face=nunito,arial,verdana>");
            //Titulo del HTML
            pw.println("<title>Reporte de Jugador</title>");
            pw.println("<center>");
            
            //Encabezado con mi informacion
            pw.println("<h1>Adrian Ismael Orlando Garcia Balan - 202102775</h1>");
            pw.println("<p>");
            pw.println("<p>");
            
            //Dificultad
            pw.println("<h2>Dificultad prueba</h2>");
            pw.println("<p>");
            pw.print("Jugo el nivel: " +Facil);
            pw.println("<p>");
            pw.print("Jugo el nivel: " +Medio);
            pw.println("<p>");
            pw.print("Jugo el nivel: " +Dificil);
            pw.println("<p>");
            pw.println("<p>");
            
            //Intervalo
            pw.println("<h2>Intervalo</h2>");
            pw.println("<p>");
            pw.println("<p>");
            
            //Tamaño de la serpiente
            pw.println("<h2>Tamaño de Serpiente en puntos</h2>");
            pw.print("Su puntaje es: " +puntos);
            pw.println("<p>");
            pw.println("<p>");
            
            //Historial de movimientos
            pw.println("<h2>Historial de Movimientos</h2>");
            pw.println("Sus Movimientos Hacia Arriba Fueron: " +cantidad_ar);
            pw.println("<p>");
            pw.println("Sus Movimientos Hacia abajo Fueron: " +cantidad_ab);
            pw.println("<p>");
            pw.println("Sus Movimientos Hacia La Izquierda Fueron: " +cantidad_iz);
            pw.println("<p>");
            pw.println("Sus Movimientos Hacia La Derecha Fueron: " +cantidad_de);
            pw.println("<p>");
            pw.println("<p>");
            
            //Tiempo transcurrido
            pw.println("<h2>Tiempo Transcurrido</h2>");
            pw.println("Usted jugo en la hora: " +horas+":"+minutos+":"+segundos);
            pw.println("</font>");
            pw.println("</body>");
            pw.println("</HTML>");
            
            
            
        } catch (Exception i) {
            
            i.printStackTrace();
        }finally{
            
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception i) {
                i.printStackTrace();
            }
        }
    }
    
    
    
    //Cronometro

    
// public  void Crono() {
//     
//     try {
//         for (horas = 0; horas < 12; horas++) {
//         for (minutos = 0; minutos < 60; minutos++) {
//             for ( segundos = 0; segundos < 60; segundos++) {
//                 System.out.println(horas+":"+minutos+":"+segundos);
//                 Thread.sleep(1000);
//                 ti.setText(horas+":"+minutos+":"+segundos);
//             } 
//         }
//     }
//     
//    
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//     
//  }
    
    //Cronometro
    public void cronometro(){
        
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        
        while(ct==h1){
            calcula();
            
            ti.setText(horas+":"+minutos+":"+segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
//Calculadora de horas
    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
         ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
         if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            horas = h > 9 ? "" + h : "0" + h;
            if(h==00){
                   horas="12";
             }else{
                   horas=h>9?""+h:"0"+h;
             }      
        } else {
            horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    
    
  
    }

