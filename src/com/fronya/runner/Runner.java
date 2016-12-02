package com.fronya.runner;


import com.fronya.candies.Candies;
import com.fronya.marshaling.Marshalling;
import com.fronya.stax.StAXParser;
import com.fronya.unmarshalling.Unmarshalling;

public class Runner {
    private static String NAME_FILE = "xml/candies.xml";
    private static String NAME_NEW_FILE = "xml/candies_marshal.xml";
    private static String NAME_STAX_FILE = "xml/candies_stax.xml";

    public static void main(String[] args) {
        Unmarshalling unmarshallingCandies = new Unmarshalling(NAME_FILE);
        Candies candies = unmarshallingCandies.getCandies();
        System.out.println("Unmarshalling");
        System.out.println(candies);

        Marshalling marshallingCandies = new Marshalling(NAME_NEW_FILE);
        if(marshallingCandies.toFile(candies)){
            System.out.println("Marshalling was finished");
        }else{
            System.out.println("Marshalling wasn't finished");
        }

        StAXParser staxParser = new StAXParser(NAME_STAX_FILE);
        if(staxParser.createFile(candies)){
            System.out.println("File was created");
        }else{
            System.out.println("File wasn't created");
        }
    }
}
