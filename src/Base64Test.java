import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lideqing@xiaomi.com on 19-3-15
 */
public class Base64Test {

	public static void main ( String []args) {
		String str = "eyJyZXF1ZXN0Ijp7IjEiOiIzMjcxMDMxNTE3MzYzNTYzMTg1IiwiOSI6IlJlZG1pTm90ZTRYIiwiMTQiOiJhZjcyZTQ5OTliYTNjMGJlIiwiNSI6IlYyLjYwIiwiNiI6ImNvbS5iYWl3YW4ucGsiLCIzNyI6ImNoYW5uZWxUZXN0IiwiMzgiOiI3LjAiLCIxMyI6IjQ2MDAyIiwiOCI6ImFuZHJvaWQiLCIxNiI6InpoIiwiNCI6IkNOIiwiMzU5IjoiYWY3MmU0OTk5YmEzYzBiZSIsIjEwIjoibnVsbCIsIjMiOiI0Mjk4ZmQ2MzFjODFkMjI1NDBmZGRmMWFlZWMyNDMwZSIsIjM1NyI6IjA3YmNjZjdkYWYzOWQxNWMwODlmMWE0ODgyMmRiYzg5IiwiMiI6IjExODI3OTUiLCIzNTgiOjEsImV2ZW50cyI6W3siMzEiOiIxNTUyNTQ5ODc4NjA4IiwiMTciOiIxMC4yMzUuMjE0LjcxIiwiMTIiOjAsIi0xIjoiMTE4Mjc5NTE1NTI1NDk4Nzg2MTA4MiIsIjIiOiIxMTgyNzk1IiwiMjEiOiJFWFBPU0UiLCIyNyI6W3siMTAyIjoiMTAwNDYwMSIsIjEwMyI6IuWNg+eCruaNlemxvCIsIjEwNCI6ImdhbWUiLCIyMiI6bnVsbCwiMTA2Ijoi6aaW6aG1IiwiMTA3Ijoi5qyi5LmQ5qOL54mMIiwiMTA4IjpudWxsLCIxMDkiOjMsIjEwMSI6IkVYUE9TRSJ9XX0seyIzMSI6IjE1NTI1NDk4Nzg2MTEiLCIxNyI6IjEwLjIzNS4yMTQuNzEiLCIxMiI6MCwiLTEiOiIxMTgyNzk1MTU1MjU0OTg3ODYxMzY2IiwiMiI6IjExODI3OTUiLCIyMSI6IkVYUE9TRSIsIjI3IjpbeyIxMDIiOiIxMDA2MDAxIiwiMTAzIjoi5aSa5LmQ6LS16Ziz5o2J6bihIiwiMTA0IjoiZ2FtZSIsIjIyIjpudWxsLCIxMDYiOiLpppbpobUiLCIxMDciOiLmrKLkuZDmo4vniYwiLCIxMDgiOm51bGwsIjEwOSI6NCwiMTAxIjoiRVhQT1NFIn1dfSx7IjMxIjoiMTU1MjU0OTg3ODYxNSIsIjE3IjoiMTAuMjM1LjIxNC43MSIsIjEyIjowLCItMSI6IjExODI3OTUxNTUyNTQ5ODc4NjE3NDEiLCIyIjoiMTE4Mjc5NSIsIjIxIjoiRVhQT1NFIiwiMjciOlt7IjEwMiI6IjEwMDY5MDEiLCIxMDMiOiLlj6PnuqLmnLoiLCIxMDQiOiJnYW1lIiwiMjIiOm51bGwsIjEwNiI6IummlumhtSIsIjEwNyI6IuaWsOWTgeaOqOiNkCIsIjEwOCI6bnVsbCwiMTA5IjoxLCIxMDEiOiJFWFBPU0UifV19LHsiMzEiOiIxNTUyNTQ5ODc4NjE3IiwiMTciOiIxMC4yMzUuMjE0LjcxIiwiMTIiOjAsIi0xIjoiMTE4Mjc5NTE1NTI1NDk4Nzg2MTk1MCIsIjIiOiIxMTgyNzk1IiwiMjEiOiJFWFBPU0UiLCIyNyI6W3siMTAyIjoiMTAwNjIwMSIsIjEwMyI6IuWFreeVjOS7meWwiiIsIjEwNCI6ImdhbWUiLCIyMiI6bnVsbCwiMTA2Ijoi6aaW6aG1IiwiMTA3Ijoi5paw5ZOB5o6o6I2QIiwiMTA4IjpudWxsLCIxMDkiOjIsIjEwMSI6IkVYUE9TRSJ9XX0seyIzMSI6IjE1NTI1NDk4Nzg2MjAiLCIxNyI6IjEwLjIzNS4yMTQuNzEiLCIxMiI6MCwiLTEiOiIxMTgyNzk1MTU1MjU0OTg3ODYyMjYxIiwiMiI6IjExODI3OTUiLCIyMSI6IkVYUE9TRSIsIjI3IjpbeyIxMDIiOiIxMDAzODAyIiwiMTAzIjoi576O55S35pyJ5q+SIiwiMTA0IjoiZ2FtZSIsIjIyIjpudWxsLCIxMDYiOiLpppbpobUiLCIxMDciOiLmlrDlk4HmjqjojZAiLCIxMDgiOm51bGwsIjEwOSI6MywiMTAxIjoiRVhQT1NFIn1dfV19fQ==";
		String baseStr = new String(Base64.getDecoder().decode(str));
		System.out.println(baseStr);
		final String rule = "[\n"
			+ "  {\n"
			+ "    \"resource\": \"TestResource\",\n"
			+ "    \"controlBehavior\": 0,\n"
			+ "    \"count\": 10.0,\n"
			+ "    \"grade\": 1,\n"
			+ "    \"limitApp\": \"default\",\n"
			+ "    \"strategy\": 0\n"
			+ "  }\n"
			+ "]";
		System.out.println(rule);
		ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(1,2);
		concurrentHashMap.put(2,3);
		concurrentHashMap.put(17,1);
		concurrentHashMap.put(33,1);
		concurrentHashMap.put(49,1);
		concurrentHashMap.put(65,1);

	}

}
