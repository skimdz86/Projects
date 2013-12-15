//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.07 at 09:27:19 PM CEST 
//


package com.cleartrip.air;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.cleartrip.com/air/}index"/>
 *         &lt;element ref="{http://www.cleartrip.com/air/}fare-basis-code"/>
 *         &lt;element ref="{http://www.cleartrip.com/air/}fare-key" minOccurs="0"/>
 *         &lt;element ref="{http://www.cleartrip.com/air/}pricing-elements"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "index",
    "fareBasisCode",
    "fareKey",
    "pricingElements"
})
@XmlRootElement(name = "pricing-info")
public class PricingInfo {

    @XmlElement(required = true)
    protected BigInteger index;
    @XmlElement(name = "fare-basis-code", required = true)
    protected String fareBasisCode;
    @XmlElement(name = "fare-key")
    protected String fareKey;
    @XmlElement(name = "pricing-elements", required = true)
    protected PricingElements pricingElements;

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndex(BigInteger value) {
        this.index = value;
    }

    /**
     * Gets the value of the fareBasisCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareBasisCode() {
        return fareBasisCode;
    }

    /**
     * Sets the value of the fareBasisCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareBasisCode(String value) {
        this.fareBasisCode = value;
    }

    /**
     * Gets the value of the fareKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareKey() {
        return fareKey;
    }

    /**
     * Sets the value of the fareKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareKey(String value) {
        this.fareKey = value;
    }

    /**
     * Gets the value of the pricingElements property.
     * 
     * @return
     *     possible object is
     *     {@link PricingElements }
     *     
     */
    public PricingElements getPricingElements() {
        return pricingElements;
    }

    /**
     * Sets the value of the pricingElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link PricingElements }
     *     
     */
    public void setPricingElements(PricingElements value) {
        this.pricingElements = value;
    }

}
