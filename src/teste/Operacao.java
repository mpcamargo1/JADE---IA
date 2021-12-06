/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


/**
 *
 * @author marcospaulo
 */
public class Operacao {
    
     public static Integer sum(java.lang.Integer num1, java.lang.Integer num2) {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.sum(num1, num2);
    }
     
      public static Integer sub(java.lang.Integer num1, java.lang.Integer num2) {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.sub(num1, num2);
    }
      
      public static com.service.Musica addClass() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.addClass();
    }
      
      public static Integer addNumber() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.addNumber();
    }
      
      public static Double getTemperature() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.getTemperature();
    }
      
      public static com.service.BloodPressure getBloodPressure() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.getBloodPressure();
    }
      
      public static Double getHeartRate() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.getHeartRate();
    }
      
      public static Double getGlicose() {
        com.service.CPS_Service service = new com.service.CPS_Service();
        com.service.CPS port = service.getCPSPort();
        return port.getGlucose();
    }
      
      
      
      /* -----------------------------Backup-----------------------------------*/
      
      public static Integer addNumberBackup() {
        com.service.Backup_Service service = new com.service.Backup_Service();
        com.service.Backup port = service.getBackupPort();
        return port.addNumber();
    }
      
       public static Double getTemperatureBackup() {
        com.service.Backup_Service service = new com.service.Backup_Service();
        com.service.Backup port = service.getBackupPort();
        return port.getTemperature();
    }
      
      public static com.service.BloodPressure getBloodPressureBackup() {
        com.service.Backup_Service service = new com.service.Backup_Service();
        com.service.Backup port = service.getBackupPort();
        return port.getBloodPressure();
    }
      
      public static Double getHeartRateBackup() {
        com.service.Backup_Service service = new com.service.Backup_Service();
        com.service.Backup port = service.getBackupPort();
        return port.getHeartRate();
    }
      
       public static Double getGlicoseBackup() {
        com.service.Backup_Service service = new com.service.Backup_Service();
        com.service.Backup port = service.getBackupPort();
        return port.getGlicose();
    }
      
}
