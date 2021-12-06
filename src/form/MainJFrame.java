/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import Agentes.collector;
import com.service.BloodPressure;
import java.awt.BorderLayout;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import teste.Busca;
import teste.Data;
        

/**
 *
 * @author marcospaulo
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form Hello
     */
    
    TimeSeries seriesTemperature,seriesDiastolic,seriesSystolic,seriesHeartRate,seriesGlicose;
    Timer timer;
    
   ScheduledExecutorService executor;
    
    public MainJFrame() {
        initComponents();
        jPanel4.setLayout(new BorderLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        InicializarMenuItem = new javax.swing.JMenuItem();
        AtualizarMenuItem = new javax.swing.JMenuItem();
        PararMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cyber-Physical System");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ambiente ", jPanel4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane2.addTab("Monitoramento", jPanel1);

        jScrollPane1.setViewportView(jList1);

        jButton4.setText("Visualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(30, 30, 30))
        );

        jTabbedPane2.addTab("Agentes", jPanel2);

        jMenu1.setText("Agentes");

        jMenu3.setText("Desativar");

        jMenuItem1.setText("Collector");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Diagnostic");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Manager");
        jMenu3.add(jMenuItem4);

        jMenuItem13.setText("Negotiation");
        jMenu3.add(jMenuItem13);

        jMenuItem5.setText("Ontology");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Processing Data");
        jMenu3.add(jMenuItem6);

        jMenuItem2.setText("Agente Busca");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenu4.setText("Ativar");

        jMenuItem7.setText("Collector");
        jMenu4.add(jMenuItem7);

        jMenuItem9.setText("Diagnotic");
        jMenu4.add(jMenuItem9);

        jMenuItem8.setText("Manager");
        jMenu4.add(jMenuItem8);

        jMenuItem10.setText("Negotiation");
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("Ontology");
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("Processing Data");
        jMenu4.add(jMenuItem12);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Ação");

        jMenu6.setText("Ambiente 1");

        InicializarMenuItem.setText("Inicializar");
        InicializarMenuItem.setName(""); // NOI18N
        InicializarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicializarMenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(InicializarMenuItem);

        AtualizarMenuItem.setText("Atualizar");
        AtualizarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarMenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(AtualizarMenuItem);

        PararMenuItem.setText("Parar");
        PararMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PararMenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(PararMenuItem);

        jMenu5.add(jMenu6);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Informações");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       String texto;
       DefaultListModel dlm = new DefaultListModel();
       
        for(int i = 0; i < jList1.getModel().getSize(); i++) {
         dlm.addElement(jList1.getModel().getElementAt(i));
        }
        
        while(!Agentes.manager.queue.isEmpty()){
            texto = Agentes.manager.queue.remove();
            dlm.addElement(texto + "\n");
            
        }
        jList1.setModel(dlm);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Busca.alive = false;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultListModel dlm = new DefaultListModel();
        dlm.removeAllElements();
        jList1.setModel(dlm);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void InicializarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicializarMenuItemActionPerformed
        // TODO add your handling code here:
        
        
         
         seriesTemperature= new TimeSeries("Temperature(ºC)",Second.class); 
         seriesDiastolic= new TimeSeries("Diastolic(mmHg)",Second.class);  
         seriesSystolic = new TimeSeries("Systolic(mmHg)",Second.class);
         seriesHeartRate = new TimeSeries("HeartRate(BPM)",Second.class);
         seriesGlicose = new TimeSeries("Glicose(mg/dL)",Second.class);
         final TimeSeriesCollection data_2 = new TimeSeriesCollection();
         final JFreeChart graphic_2 = ChartFactory.createTimeSeriesChart("Monitoramento", "Tempo", "Valor", data_2);
         
         
         Second mnt = new Second();
         BloodPressure bp = collector.queue_BloodPressure.poll();
         seriesDiastolic.add(mnt, bp.getDiastolic()); 
         seriesSystolic.add(mnt, bp.getSystolic()); 
         seriesTemperature.add(mnt, collector.queue_Temperature.poll());
         seriesHeartRate.add(mnt,collector.queue_HeartRate.poll());
         seriesGlicose.add(mnt,collector.queue_Glicose.poll());

         data_2.addSeries(seriesTemperature);  
         data_2.addSeries(seriesDiastolic);
         data_2.addSeries(seriesSystolic);
         data_2.addSeries(seriesHeartRate);
         data_2.addSeries(seriesGlicose);

         
         ChartPanel panel_2 = new ChartPanel(graphic_2);
         
         
         panel_2.setVisible(true);
         panel_2.setSize(jPanel4.getWidth(), jPanel4.getHeight());
         panel_2.setLocation(0, 0);
         
       
         jPanel4.add(panel_2);
         jPanel4.updateUI();
        
           /*
            com.service.Musica msc = new com.service.Musica();
            msc.setNome("All Time Low");
            msc.setAlbum("Wake Up Sunshine");
            Agente.queue.add(msc);
            com.service.Musica msc1 = new com.service.Musica();
            msc1.setNome("ATL");
            msc1.setAlbum("Dirty Work");
            Agente.queue.add(msc1);
            */
        
    }//GEN-LAST:event_InicializarMenuItemActionPerformed

    private void AtualizarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarMenuItemActionPerformed
        // TODO add your handling code here:
        
        int i=0;
        
        TimerTask task = new TimerTask() {
        public void run() {
            Second mnt = new Second();
            BloodPressure bp;
            if(collector.queue_Temperature.size() > 0 & collector.queue_BloodPressure.size() > 0
                    & collector.queue_HeartRate.size() > 0 & collector.queue_Glicose.size() > 0){
                bp =  collector.queue_BloodPressure.poll();
                seriesDiastolic.addOrUpdate(mnt,bp.getDiastolic());
                seriesSystolic.addOrUpdate(mnt,bp.getSystolic());
                seriesTemperature.addOrUpdate(mnt,collector.queue_Temperature.poll());
                seriesHeartRate.addOrUpdate(mnt,collector.queue_HeartRate.poll());
                seriesGlicose.addOrUpdate(mnt,collector.queue_Glicose.poll());
               }
            }
        };
         
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            long delay  = 1000L;
            long period = 1000L;
        executor.scheduleAtFixedRate(task, delay, period, TimeUnit.MILLISECONDS); 
  
        
    }//GEN-LAST:event_AtualizarMenuItemActionPerformed

    private void PararMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PararMenuItemActionPerformed
        // TODO add your handling code here:
        
        executor.shutdown();
        
    }//GEN-LAST:event_PararMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AtualizarMenuItem;
    private javax.swing.JMenuItem InicializarMenuItem;
    private javax.swing.JMenuItem PararMenuItem;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}