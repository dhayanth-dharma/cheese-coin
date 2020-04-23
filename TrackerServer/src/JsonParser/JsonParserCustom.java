/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonParser;

import Model.CheeseModel;
import Model.Cheese_M;
import Model.Member_M;
import Model.RequestModel;
import Model.ResponseModel;
import Model.Transaction_M;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class JsonParserCustom<T> {

    private ObjectMapper mapper;
    Class<T> typeParameterClass;
    Class<T>[] typeParameterClassList;
    public JsonParserCustom(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        mapper=new ObjectMapper();
    }
    public JsonParserCustom(Class<T>[] typeParameterClassList) {
        this.typeParameterClassList = typeParameterClassList;
        mapper=new ObjectMapper();
    }
    
    public JsonParserCustom() {
        mapper=new ObjectMapper();
        
    }
    
    public RequestModel stringToReqObj(String clientMessage)
    {
        
        try {
            
            RequestModel req = mapper.readValue(clientMessage, RequestModel.class);
            return req;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
      public ResponseModel stringToResObj(String clientMessage)
    {
        
        try {
            ResponseModel req = mapper.readValue(clientMessage, ResponseModel.class);
        
            return req;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public List<T> stringToObjectList(String jsonString)
    {
        
        try {
            List<T> list = new ArrayList<T>();
            list = Arrays.asList((T[]) mapper.readValue(jsonString, Cheese_M[].class));
            return list;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public List<T> stringToObjectListGeneric(String jsonString)
    {
        
        try {
            List<T> lists = new ArrayList<T>();
            lists = Arrays.asList((T[]) mapper.readValue(jsonString, Member_M[].class));
            return lists;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public T stringToObject(String jsonString)
    {
        
        try {
            T lisst ;
            lisst =  mapper.readValue(jsonString, typeParameterClass);
            return lisst;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    public JSONObject stringToJsonObj(String clientMessage)
    {
        
        JSONObject obj = new JSONObject(clientMessage);
//        String test =  obj.get("command").toString();
        return obj;
    }
    
    public String objectToJsonString(Object obj)
    {
        try {
            String jsonStr = mapper.writeValueAsString(obj);
            return jsonStr;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public String memberListToJsonString(List<Member_M> obj)
    {
        try {
            String jsonStr = mapper.writeValueAsString(obj);
            return jsonStr;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<CheeseModel> readJsonFileToObjBlcokChain(String url)
    {
        try {
            List<CheeseModel> obj = Arrays.asList(mapper.readValue(new File(url), CheeseModel[].class));
            return obj;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Transaction_M readJsonFileToTransaction(String url)
    {
        try {
            
//            //JSON URL to Java object
            Transaction_M obj = mapper.readValue(new File(url), Transaction_M.class);
            return obj;
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public T readJsonFileToObj(String url)
    {
        try {
            T obj = (mapper.readValue(new File(url), typeParameterClass));
            return obj;
            
        } catch (IOException ex) {
            Logger.getLogger(JsonParserCustom.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void readJsonFileToJsonObj(String url)
    {
      JSONObject obj = new JSONObject(new File(url));
    }
 
    
}
