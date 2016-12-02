//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.30 at 06:34:20 PM MSK 
//


package com.fronya.ingredient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ingredient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ingredient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="water" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="sugar" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="fructose" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="typeChocolate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vanillin" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingredient", propOrder = {
    "water",
    "sugar",
    "fructose",
    "typeChocolate",
    "vanillin"
})
public class Ingredient {

    protected float water;
    protected float sugar;
    protected float fructose;
    protected String typeChocolate;
    protected float vanillin;

    /**
     * Gets the value of the water property.
     * 
     */
    public float getWater() {
        return water;
    }

    /**
     * Sets the value of the water property.
     * 
     */
    public void setWater(float value) {
        this.water = value;
    }

    /**
     * Gets the value of the sugar property.
     * 
     */
    public float getSugar() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property.
     * 
     */
    public void setSugar(float value) {
        this.sugar = value;
    }

    /**
     * Gets the value of the fructose property.
     * 
     */
    public float getFructose() {
        return fructose;
    }

    /**
     * Sets the value of the fructose property.
     * 
     */
    public void setFructose(float value) {
        this.fructose = value;
    }

    /**
     * Gets the value of the typeChocolate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeChocolate() {
        return typeChocolate;
    }

    /**
     * Sets the value of the typeChocolate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeChocolate(String value) {
        this.typeChocolate = value;
    }

    /**
     * Gets the value of the vanillin property.
     * 
     */
    public float getVanillin() {
        return vanillin;
    }

    /**
     * Sets the value of the vanillin property.
     * 
     */
    public void setVanillin(float value) {
        this.vanillin = value;
    }

    @Override
    public String toString() {
        return "Ingredient " +
                "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", vanillin=" + vanillin;
    }


    public String toStringChocolate(){
        return toString() +
                ", typeChocolate= " + typeChocolate;
    }
}