package SQLModules;

import java.util.ArrayList;
import java.util.HashMap;

import SupportLibraryClasses.SQL;

public class sample {
	// Retrieve rows based on condition :Created by GG
		public static ArrayList<HashMap<String,String>> retrieveUnitDetails(String whereFields,String whereValues) {
			String fields = "Id,Name";		
			return SQL.retrieveBySorting(fields, "SampleTableName", whereFields, whereValues,"CREATEDON","DESC","AND");
		}

}
