
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maza
 */
public class Principal extends javax.swing.JFrame {

    public static class jugadores{
        String nombre;
        Integer cantidad;
        Integer tipo;
        externalParameters parametros;
        jugadores siguiente;
    }
    
    public static class externalParameters{
        String key;
        String value;
        externalParameters siguiente;
        
    }
    public static class objetoPlantaZombie{
        Integer indice;
        String nombre;
        String imagen;
        Integer ataque;
        Integer defensa;
        Integer tipoAtaque;

        objetoPlantaZombie siguiente;
    }
    
    static jugadores jugador=null;
    static externalParameters parametros;
    static objetoPlantaZombie plantas=null;
    static objetoPlantaZombie zombies=null;
    static objetoPlantaZombie pila=null;
    static objetoPlantaZombie cola=null;
    static objetoPlantaZombie fondo=null;
    static Integer sequence=0;
    
    public static void add_jugador(jugadores cab,externalParameters parametros,String nombre,String cantidad,Integer tipo){
        jugadores nuevo,copia;
        nuevo = new jugadores();
        nuevo.nombre = nombre;
        nuevo.cantidad=Integer.parseInt(cantidad);
        nuevo.parametros=parametros;
        nuevo.tipo=tipo;
        nuevo.siguiente = null;
        if(cab == null)
            cab = nuevo;
        else{
            copia = cab;
            while(copia.siguiente!=null){
                copia = copia.siguiente;
            }
            copia.siguiente = nuevo;
        }
        jugador=cab;
    }
    
    public static void add_parametros(externalParameters cab,String key,String value){
        externalParameters nuevo,copia;
        nuevo = new externalParameters();
        nuevo.key=key;
        nuevo.value=value;
        nuevo.siguiente = null;
        if(cab == null)
            cab = nuevo;
        else{
            copia = cab;
            while(copia.siguiente!=null){
                copia = copia.siguiente;
            }
            copia.siguiente = nuevo;
        }
        parametros=cab;
    }
    
    public static void listado(objetoPlantaZombie cab){
        while(cab != null){ 
            cab=cab.siguiente;
        }
    }
    
    public static void listadoPlayers(jugadores cab){
        while(cab != null){
            System.out.println("------Jugador------");
            System.out.println(cab.nombre);
            System.out.println(cab.cantidad);
            externalParameters parametros = cab.parametros;
            while(parametros!=null){
                System.out.println("------Parametros------");
                System.out.println(parametros.key);
                System.out.println(parametros.value);
                
                parametros=parametros.siguiente;
            }
            cab=cab.siguiente;
        }
    }
    
    public static void add_planta(objetoPlantaZombie cab,Integer indice, String nombre,String imagen,Integer defensa,Integer ataque,Integer tipoAtaque){
        objetoPlantaZombie nuevo,copia;
        nuevo = new objetoPlantaZombie();
        nuevo.indice=indice;
        nuevo.nombre=nombre;
        nuevo.imagen=imagen;
        nuevo.ataque=ataque;
        nuevo.defensa=defensa;
        nuevo.tipoAtaque=tipoAtaque;
        nuevo.siguiente = null;
        if(cab == null)
            cab = nuevo;
        else{
            copia = cab;
            while(copia.siguiente!=null){
                copia = copia.siguiente;
            }
            copia.siguiente = nuevo;
        }
        sequence++;
        plantas=cab;
    }
    
    public static void add_zombie(objetoPlantaZombie cab,Integer indice, String nombre,String imagen,Integer defensa,Integer ataque,Integer tipoAtaque){
        objetoPlantaZombie nuevo,copia;
        nuevo = new objetoPlantaZombie();
        nuevo.indice=indice;
        nuevo.nombre=nombre;
        nuevo.imagen=imagen;
        nuevo.ataque=ataque;
        nuevo.defensa=defensa;
        nuevo.tipoAtaque=tipoAtaque;
        nuevo.siguiente = null;
        if(cab == null)
            cab = nuevo;
        else{
            copia = cab;
            while(copia.siguiente!=null){
                copia = copia.siguiente;
            }
            copia.siguiente = nuevo;
        }
        sequence++;
        zombies=cab;
    }
    
    public static String[] vectorObject(objetoPlantaZombie lista){
        String[] array = new String[100];
        Integer indice=0;
        while(lista != null){
            array[indice]=lista.nombre;
            indice++;
            lista=lista.siguiente;
        }
        return array;
    }
    
    public static objetoPlantaZombie findObject(objetoPlantaZombie lista,String nombre){
        while(lista !=null){
            if(lista.nombre.equalsIgnoreCase(nombre)){
                return lista;
            }
            lista=lista.siguiente;
        }
        return null;
    }
    
    public static void editObjectZombie(objetoPlantaZombie lista,Integer indice, String nombre,String imagen,Integer defensa,Integer ataque,Integer tipoAtaque){
        objetoPlantaZombie copia = lista;
        objetoPlantaZombie anterior = null;
        while(copia!=null){
            if(copia.indice==indice){
                objetoPlantaZombie nuevo = new objetoPlantaZombie();
                nuevo.indice=indice;
                nuevo.nombre=nombre;
                nuevo.imagen=imagen;
                nuevo.ataque=ataque;
                nuevo.defensa=defensa;
                nuevo.tipoAtaque=tipoAtaque;
                if(anterior==null){
                    nuevo.siguiente=copia.siguiente;
                    zombies=nuevo;
                    break;
                }else{
                    anterior.siguiente=nuevo;
                    nuevo.siguiente=copia.siguiente;
                    zombies=lista;
                    break;    
                }
            }
            anterior=copia;
            copia=copia.siguiente;
        }
        
    }

    public static void deleteObjectZombie(objetoPlantaZombie lista,Integer indice){
        objetoPlantaZombie copia = lista;
        objetoPlantaZombie anterior = null;
        while(copia!=null){
            if(copia.indice==indice){
                if(anterior==null){
                    copia=copia.siguiente;
                    zombies=copia;
                    break;
                }else{
                    anterior.siguiente=copia.siguiente;
                    zombies=lista;
                    break;
                }
            }
            anterior=copia;
            copia=copia.siguiente;   
        }
    }
  
    public static void editObjectPlanta(objetoPlantaZombie lista,Integer indice, String nombre,String imagen,Integer defensa,Integer ataque,Integer tipoAtaque){
        objetoPlantaZombie copia = lista;
        objetoPlantaZombie anterior = null;
        while(copia!=null){
            if(copia.indice==indice){
                objetoPlantaZombie nuevo = new objetoPlantaZombie();
                nuevo.indice=indice;
                nuevo.nombre=nombre;
                nuevo.imagen=imagen;
                nuevo.ataque=ataque;
                nuevo.defensa=defensa;
                nuevo.tipoAtaque=tipoAtaque;
                if(anterior==null){
                    nuevo.siguiente=copia.siguiente;
                    plantas=nuevo;
                    break;
                }else{
                    anterior.siguiente=nuevo;
                    nuevo.siguiente=copia.siguiente;
                    plantas=lista;
                    break;    
                }
            }
            anterior=copia;
            copia=copia.siguiente;
        }
        
    }

    public static void deleteObjectPlanta(objetoPlantaZombie lista,Integer indice){
        objetoPlantaZombie copia = lista;
        objetoPlantaZombie anterior = null;
        while(copia!=null){
            if(copia.indice==indice){
                if(anterior==null){
                    copia=copia.siguiente;
                    plantas=copia;
                    break;
                }else{
                    anterior.siguiente=copia.siguiente;
                    plantas=lista;
                    break;
                }
            }
            anterior=copia;
            copia=copia.siguiente;   
        }
    }
    
    public void insertarPila(objetoPlantaZombie pila,Integer indice,String nombre, String imagen,Integer ataque,Integer defensa,Integer tipoAtaque) {
    	objetoPlantaZombie nuevo;
        nuevo = new objetoPlantaZombie();
        nuevo.indice=indice;
        nuevo.nombre=nombre;
        nuevo.imagen=imagen;
        nuevo.ataque=ataque;
        nuevo.defensa=defensa;
        nuevo.tipoAtaque=tipoAtaque;
        if (pila==null)
        {
            nuevo.siguiente = null;
            this.pila = nuevo;
        }
        else
        {
            nuevo.siguiente = pila;
            this.pila = nuevo;
        }
    }
    
    public void extraerPila (objetoPlantaZombie pila)
    {
        if (pila!=null)
        {
            pila = pila.siguiente;
        }
        else
        {
            System.out.println("Pila Vacia");
        }
    }
    
    public void imprimirPila(objetoPlantaZombie pila) {
        objetoPlantaZombie reco=pila;
        while (reco!=null) {   
            System.out.println(reco.indice);
            System.out.println(reco.nombre);
            System.out.println(reco.imagen);
            System.out.println(reco.ataque);
            System.out.println(reco.defensa);
            System.out.println(reco.tipoAtaque);
            
            reco=reco.siguiente;
        }
    }
    
    
    public boolean vacia (objetoPlantaZombie cola){
        if (cola == null)
            return true;
        else
            return false;
    }

    public void insertarCola (objetoPlantaZombie cola,Integer indice,String nombre, String imagen,Integer ataque,Integer defensa,Integer tipoAtaque) {
    
        objetoPlantaZombie nuevo;
        nuevo = new objetoPlantaZombie();
        nuevo.indice=indice;
        nuevo.nombre=nombre;
        nuevo.imagen=imagen;
        nuevo.ataque=ataque;
        nuevo.defensa=defensa;
        nuevo.tipoAtaque=tipoAtaque;
        nuevo.siguiente = null;
        if (vacia (cola)) {
            this.cola = nuevo;
            fondo = nuevo;
        } else {
            fondo.siguiente = nuevo;
            fondo = nuevo;
        }
    }

    public void extraerCola(objetoPlantaZombie cola){
        if (!vacia (cola))
        {
            if (cola == fondo){
                this.cola = null;
                fondo = null;
            } else {
                this.cola = this.cola.siguiente;
            }
        } else{
           System.out.println("Cola vacia");
        }
    }

    public void imprimirCola(objetoPlantaZombie cola) {
        objetoPlantaZombie reco=cola;
        while (reco!=null) {
            System.out.println(reco.indice);
            System.out.println(reco.nombre);
            System.out.println(reco.imagen);
            System.out.println(reco.ataque);
            System.out.println(reco.defensa);
            System.out.println(reco.tipoAtaque);
            reco=reco.siguiente;
        }
    }
    
    private void generarReporte(jugadores lista,objetoPlantaZombie plantas,objetoPlantaZombie zombies){
    
        try
        {
            
            FileWriter fichero = null;
            PrintWriter pw = null;
         
            fichero = new FileWriter("Jugadores.txt");
                pw = new PrintWriter(fichero);
                
                pw.println("digraph G {");
                String anterior="Jugadores";
                String actual = new String();
                while(lista != null){
                    actual="\""+lista.nombre+"\n"+lista.cantidad+"\"";
                    pw.println(anterior+"->"+actual);
                    anterior=actual;
                    externalParameters parametros = lista.parametros;
                    while(parametros!=null){
                        actual="\""+parametros.key+"\n"+parametros.value+"\"";
                        pw.println(anterior+"->"+actual);
                        anterior=actual;
                        
                        parametros=parametros.siguiente;
                    }
                    anterior="\""+lista.nombre+"\n"+lista.cantidad+"\"";
                    lista=lista.siguiente;
                }
                pw.println("}");

                if (null != fichero)
                    fichero.close();
                      

            Runtime rt = Runtime.getRuntime();
            String cmd="dot -Tpng Jugadores.txt -o Jugadores.png";
            rt.exec(cmd);
            
            
            FileWriter fichero2 = null;
            PrintWriter pw2 = null;
            
            fichero2 = new FileWriter("Plantas.txt");
            pw2 = new PrintWriter(fichero2);
                
            pw2.println("digraph G {");
            String anterior2="Plantas";
            while(plantas != null){ 
                String actual2="\""+plantas.nombre+"\n"+plantas.imagen+"\n"+plantas.ataque+"\n"+plantas.defensa+"\n"+plantas.tipoAtaque+"\"";
                pw2.println(anterior2+"->"+actual2);
                anterior2=actual2;
                plantas=plantas.siguiente;
            }
            pw2.println("}");
            
            if (null != fichero2)
                fichero2.close();
            
            Runtime rt2 = Runtime.getRuntime();
            String cmd2="dot -Tpng Plantas.txt -o Plantas.png";
            rt2.exec(cmd2);
            
            
            
            FileWriter fichero3 = null;
            PrintWriter pw3 = null;
            
            fichero3 = new FileWriter("Zombies.txt");
            pw3 = new PrintWriter(fichero3);
                
            pw3.println("digraph G {");
            String anterior3="Plantas";
            while(zombies != null){ 
                String actual3="\""+zombies.nombre+"\n"+zombies.imagen+"\n"+zombies.ataque+"\n"+zombies.defensa+"\n"+zombies.tipoAtaque+"\"";
                pw3.println(anterior3+"->"+actual3);
                anterior3=actual3;
                zombies=zombies.siguiente;
            }
            pw3.println("}");
            
            if (null != fichero3)
                fichero3.close();
            
            Runtime rt3 = Runtime.getRuntime();
            String cmd3="dot -Tpng Zombies.txt -o Zombies.png";
            rt3.exec(cmd3);
      
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
    
    }
    
    
    
    
    
    
    /**
     * Creates new form NewJFrame
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Inicio");

        jMenuItem1.setText("Configuraciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        jMenuItem2.setText("Generar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Configuraciones conf = new Configuraciones();
        conf.show();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        generarReporte(jugador,plantas,zombies);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
