
package com.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bloodPressure complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bloodPressure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diastolic" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="systolic" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bloodPressure", propOrder = {
    "diastolic",
    "systolic"
})
public class BloodPressure {

    protected Double diastolic;
    protected Double systolic;

    /**
     * Obtém o valor da propriedade diastolic.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDiastolic() {
        return diastolic;
    }

    /**
     * Define o valor da propriedade diastolic.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDiastolic(Double value) {
        this.diastolic = value;
    }

    /**
     * Obtém o valor da propriedade systolic.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSystolic() {
        return systolic;
    }

    /**
     * Define o valor da propriedade systolic.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSystolic(Double value) {
        this.systolic = value;
    }

}
