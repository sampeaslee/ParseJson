import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ParseJSONExample {

    public static void main(String[] args) throws Exception {

        Object obj = new JSONParser().parse(new FileReader("exampleJSON.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
        System.out.println(firstName);
        Map address = ((Map) jo.get("address"));
        System.out.println(address);
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        
        // getting phoneNumbers 
        JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 
        Iterator itr2 = ja.iterator(); 
        while (itr2.hasNext())  {
            JSONObject t = (JSONObject) itr2.next();
            System.out.println(t.get("type"));
        }
    }
}
