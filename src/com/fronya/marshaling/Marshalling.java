package com.fronya.marshaling;


import com.fronya.candies.Candies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Marshalling {
    private String fileName;

    public Marshalling(String fileName) {
        this.fileName = fileName;
    }

    public boolean toFile(Candies candies){
        try{
            JAXBContext context = JAXBContext.newInstance(Candies.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(candies, new FileOutputStream(fileName));
            return true;
        }catch (JAXBException ex){
            ex.printStackTrace();
            return false;
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
