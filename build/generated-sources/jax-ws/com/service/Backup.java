
package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Backup", targetNamespace = "http://service.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Backup {


    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Sum")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Sum", targetNamespace = "http://service.com/", className = "com.service.Sum")
    @ResponseWrapper(localName = "SumResponse", targetNamespace = "http://service.com/", className = "com.service.SumResponse")
    @Action(input = "http://service.com/Backup/SumRequest", output = "http://service.com/Backup/SumResponse")
    public Integer sum(
        @WebParam(name = "num1", targetNamespace = "")
        Integer num1,
        @WebParam(name = "num2", targetNamespace = "")
        Integer num2);

    /**
     * 
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTemperature", targetNamespace = "http://service.com/", className = "com.service.GetTemperature")
    @ResponseWrapper(localName = "getTemperatureResponse", targetNamespace = "http://service.com/", className = "com.service.GetTemperatureResponse")
    @Action(input = "http://service.com/Backup/getTemperatureRequest", output = "http://service.com/Backup/getTemperatureResponse")
    public Double getTemperature();

    /**
     * 
     * @return
     *     returns com.service.BloodPressure
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBloodPressure", targetNamespace = "http://service.com/", className = "com.service.GetBloodPressure")
    @ResponseWrapper(localName = "getBloodPressureResponse", targetNamespace = "http://service.com/", className = "com.service.GetBloodPressureResponse")
    @Action(input = "http://service.com/Backup/getBloodPressureRequest", output = "http://service.com/Backup/getBloodPressureResponse")
    public BloodPressure getBloodPressure();

    /**
     * 
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addNumber", targetNamespace = "http://service.com/", className = "com.service.AddNumber")
    @ResponseWrapper(localName = "addNumberResponse", targetNamespace = "http://service.com/", className = "com.service.AddNumberResponse")
    @Action(input = "http://service.com/Backup/addNumberRequest", output = "http://service.com/Backup/addNumberResponse")
    public Integer addNumber();

    /**
     * 
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGlicose", targetNamespace = "http://service.com/", className = "com.service.GetGlicose")
    @ResponseWrapper(localName = "getGlicoseResponse", targetNamespace = "http://service.com/", className = "com.service.GetGlicoseResponse")
    @Action(input = "http://service.com/Backup/getGlicoseRequest", output = "http://service.com/Backup/getGlicoseResponse")
    public Double getGlicose();

    /**
     * 
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPulseOxygen", targetNamespace = "http://service.com/", className = "com.service.GetPulseOxygen")
    @ResponseWrapper(localName = "getPulseOxygenResponse", targetNamespace = "http://service.com/", className = "com.service.GetPulseOxygenResponse")
    @Action(input = "http://service.com/Backup/getPulseOxygenRequest", output = "http://service.com/Backup/getPulseOxygenResponse")
    public Double getPulseOxygen();

    /**
     * 
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAirFlow", targetNamespace = "http://service.com/", className = "com.service.GetAirFlow")
    @ResponseWrapper(localName = "getAirFlowResponse", targetNamespace = "http://service.com/", className = "com.service.GetAirFlowResponse")
    @Action(input = "http://service.com/Backup/getAirFlowRequest", output = "http://service.com/Backup/getAirFlowResponse")
    public Double getAirFlow();

    /**
     * 
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHeartRate", targetNamespace = "http://service.com/", className = "com.service.GetHeartRate")
    @ResponseWrapper(localName = "getHeartRateResponse", targetNamespace = "http://service.com/", className = "com.service.GetHeartRateResponse")
    @Action(input = "http://service.com/Backup/getHeartRateRequest", output = "http://service.com/Backup/getHeartRateResponse")
    public Double getHeartRate();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alarm", targetNamespace = "http://service.com/", className = "com.service.Alarm")
    @ResponseWrapper(localName = "alarmResponse", targetNamespace = "http://service.com/", className = "com.service.AlarmResponse")
    @Action(input = "http://service.com/Backup/alarmRequest", output = "http://service.com/Backup/alarmResponse")
    public Double alarm(
        @WebParam(name = "arg0", targetNamespace = "")
        Double arg0);

    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Sub")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Sub", targetNamespace = "http://service.com/", className = "com.service.Sub")
    @ResponseWrapper(localName = "SubResponse", targetNamespace = "http://service.com/", className = "com.service.SubResponse")
    @Action(input = "http://service.com/Backup/SubRequest", output = "http://service.com/Backup/SubResponse")
    public Integer sub(
        @WebParam(name = "num1", targetNamespace = "")
        Integer num1,
        @WebParam(name = "num2", targetNamespace = "")
        Integer num2);

    /**
     * 
     * @return
     *     returns com.service.Musica
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addClass", targetNamespace = "http://service.com/", className = "com.service.AddClass")
    @ResponseWrapper(localName = "addClassResponse", targetNamespace = "http://service.com/", className = "com.service.AddClassResponse")
    @Action(input = "http://service.com/Backup/addClassRequest", output = "http://service.com/Backup/addClassResponse")
    public Musica addClass();

}
