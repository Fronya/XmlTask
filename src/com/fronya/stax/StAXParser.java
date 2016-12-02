package com.fronya.stax;


import com.fronya.candies.Candies;
import com.fronya.candies.Candy;
import com.fronya.candies.NutritionValue;
import com.fronya.candies.Type;
import com.fronya.ingredient.Ingredient;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StAXParser {
    private String nameFile;

    public StAXParser(String nameFile) {
        this.nameFile = nameFile;
    }

    public boolean createFile(Candies candies){
        boolean isCreate = true;

        XMLStreamWriter xmlStreamWriter = null;
        try(OutputStream writer = new FileOutputStream(nameFile)){
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(writer);

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.setPrefix(ParserConstants.PREFIX, ParserConstants.NAMESPACE_URI);
            xmlStreamWriter.writeStartElement(ParserConstants.PREFIX, ParserConstants.CANDIES, ParserConstants.NAMESPACE_URI);
            xmlStreamWriter.writeNamespace(ParserConstants.PREFIX, ParserConstants.NAMESPACE_URI);

            for (Candy c: candies.getCandy()) {
                xmlStreamWriter.writeStartElement(ParserConstants.CANDY);

                xmlStreamWriter.writeStartElement(ParserConstants.NAME);
                xmlStreamWriter.writeCharacters(c.getName());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.ENERGY);
                xmlStreamWriter.writeCharacters(c.getEnergy().toString());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.TYPE);
                xmlStreamWriter.writeCharacters(c.getType().value());
                xmlStreamWriter.writeEndElement();

                //Разбор ингредиента
                xmlStreamWriter.writeStartElement(ParserConstants.INGREDIENT);
                Ingredient currentIngredient = c.getIngredient();

                xmlStreamWriter.writeStartElement(ParserConstants.WATER);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentIngredient.getWater())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.SUGAR);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentIngredient.getSugar())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.FRUCTOSE);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentIngredient.getFructose())));
                xmlStreamWriter.writeEndElement();

                if(c.getType() == Type.CHOCOLATE){
                    xmlStreamWriter.writeStartElement(ParserConstants.TYPE_CHOCOLATE);
                    xmlStreamWriter.writeCharacters(currentIngredient.getTypeChocolate());
                    xmlStreamWriter.writeEndElement();
                }

                xmlStreamWriter.writeStartElement(ParserConstants.VANILLIN);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentIngredient.getVanillin())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeEndElement();

                //разбор пищевой ценности
                xmlStreamWriter.writeStartElement(ParserConstants.NUTRITION_VALUE);
                NutritionValue currentNitrition = c.getNutritionValue();

                xmlStreamWriter.writeStartElement(ParserConstants.PROTEIN);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentNitrition.getProtein())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.FAT);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentNitrition.getFat())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement(ParserConstants.CARBOHYDRATE);
                xmlStreamWriter.writeCharacters((String.valueOf(
                        currentNitrition.getCarbohydrate())));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
        }catch (IOException | XMLStreamException ex){
            ex.printStackTrace();
            isCreate = false;
        }finally {
            try {
                xmlStreamWriter.flush();
                xmlStreamWriter.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
                isCreate = false;
            }
        }
        return isCreate;
    }

    private static class ParserConstants{
        private static final String PREFIX = "cnd";
        private static final String NAMESPACE_URI = "http://www.fronya.com/Candies";
        private static final String CANDIES = "candies";
        private static final String CANDY = "candy";
        private static final String NAME = "name";
        private static final String ENERGY = "energy";
        private static final String TYPE = "type";
        private static final String INGREDIENT = "ingredient";
        private static final String WATER = "water";
        private static final String SUGAR = "sugar";
        private static final String FRUCTOSE = "fructose";
        private static final String VANILLIN = "vanillin";
        private static final String TYPE_CHOCOLATE = "typeChocolate";
        private static final String NUTRITION_VALUE = "nutritionValue";
        private static final String PROTEIN= "protein";
        private static final String FAT = "fat";
        private static final String CARBOHYDRATE= "carbohydrate";
    }
}
