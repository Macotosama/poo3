/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author peperony
 */
public class UnircePartida extends javax.swing.JPanel {

    /**
     * Creates new form UnircePartida
     */
    public UnircePartida() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Servidores = new javax.swing.JList<>();
        Salir = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Servidores.setBackground(new java.awt.Color(0, 204, 255));
        Servidores.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Servidores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Servidores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Servidores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(Servidores);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 780, 440));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Salir.png"))); // NOI18N
        Salir.setToolTipText("");
        Salir.setActionCommand("Salir");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.setFocusPainted(false);
        add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 140, 50));

        Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Atras.png"))); // NOI18N
        Atras.setActionCommand("AtrasUPartida");
        Atras.setBorderPainted(false);
        Atras.setContentAreaFilled(false);
        Atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atras.setFocusPainted(false);
        add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 670, 70, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/AceptarRegistrar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 640, 350, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Atras;
    public javax.swing.JButton Salir;
    public javax.swing.JList<String> Servidores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}