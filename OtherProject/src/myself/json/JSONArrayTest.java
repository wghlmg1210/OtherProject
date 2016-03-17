package myself.json;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONArrayTest {

	public static void main(String[] args) {
		String jsonString = "[{'contactName':'asd','contactIDCard':'330327199405040830','contactTelPhone':'18744493345'},{'contactName':'asd','contactIDCard':'330327199405040830','contactTelPhone':'18744493345'},{'contactName':'ewq','contactIDCard':'330327199309150829','contactTelPhone':'15734335678'}]";
		JSONArray jsonA = JSONArray.fromString(jsonString);
		System.out.println(jsonA.toString());
		Iterator<?> it = jsonA.iterator();
		while (it.hasNext()) {
			JSONObject jsonO = (JSONObject) it.next();
			System.out.println(jsonO.get("contactName"));
			System.out.println(jsonO.get("contactIDCard"));
			System.out.println(jsonO.get("contactTelPhone"));
		}
	}
	
}
