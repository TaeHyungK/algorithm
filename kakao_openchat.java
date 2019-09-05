import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class kakao_openchat {
	private static final String SUFFIX_ENTER = "님이 들어왔습니다.";
	private static final String SUFFIX_LEAVE = "님이 나갔습니다.";
	
	public static void main(String[] args) {
		String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(records);
	}

	public static String[] solution(String[] records) {
		ArrayList<String> logs = new ArrayList<String>();
		HashMap<String, String> nicknameMap = new HashMap<String, String>();
		ArrayList<String> actions = new ArrayList<String>();

		for (int i = 0; i < records.length; i++) {
			String record = records[i];
			String log = "";
			String[] splitRecord = record.split(" ");
			
			String action = splitRecord[0];
			String id = splitRecord[1];
			
			if ("Enter".equalsIgnoreCase(action)) {
				actions.add(action);
				logs.add(id);
				
				String nickname = splitRecord[2];
				nicknameMap.put(id, nickname);
			} else if ("Leave".equalsIgnoreCase(action)) {
				actions.add(action);
				logs.add(id);
			} else if ("Change".equalsIgnoreCase(action)) {
				String nickname = splitRecord[2];
				nicknameMap.put(id, nickname);
			}
		}
		
		Iterator<String> keys = nicknameMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			for (int i = 0; i < logs.size(); i++) {
				logs.set(i, logs.get(i).replace(key, nicknameMap.get(key)));
			}
		}
		
		for (int i = 0; i < logs.size(); i++) {
			String action = getSuffix(actions.get(i));
			logs.set(i, logs.get(i) + action);
		}
		
		System.out.println(logs);

		String[] answer = logs.toArray(new String[logs.size()]);
		return answer;
	}
	
	private static String getSuffix(String action) {
		String result = "";
		if ("Enter".equalsIgnoreCase(action)) {
			result = SUFFIX_ENTER;
		} else if ("Leave".equalsIgnoreCase(action)) {
			result = SUFFIX_LEAVE;
		}
		
		return result;
	}
}
