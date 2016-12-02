package com.fronya.unmarshalling;


import com.fronya.candies.Candies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Unmarshalling {
    private String nameFile;

    public Unmarshalling(String nameFile) {
        this.nameFile = nameFile;
    }

    public Candies getCandies(){
        Candies candies = null;
        JAXBContext context;
        try{
            context = JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(nameFile);
            candies = (Candies)unmarshaller.unmarshal(fileReader);
        }catch(JAXBException ex){
            ex.printStackTrace();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return candies;
    }
}
