import java.util.ArrayList;
import java.util.HashMap;

public class kakao_openchat {
	private static final String SUFFIX_ENTER = "님이 들어왔습니다.";
	private static final String SUFFIX_LEAVE = "님이 나갔습니다.";
	
	public static void main(String[] args) {
		String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(records);
	}

	public static String[] solution(String[] records) {
		ArrayList<String> ids = new ArrayList<String>();
		HashMap<String, String> nicknameMap = new HashMap<String, String>();
		ArrayList<String> actions = new ArrayList<String>();

		for (String r : records) {
			String[] splitRecord = r.split(" ");
			
			String action = splitRecord[0];
			String id = splitRecord[1];
			
			// Enter, Change 시
			if (splitRecord.length == 3) {
				String nickname = splitRecord[2];
				nicknameMap.put(id, nickname);
			};
			
			// Enter, Leave 시
			if (!"Change".equals(action)) {
				actions.add(action);
				ids.add(id);
			}
		}
		
		String[] answer = new String[ids.size()];
		for (int i = 0; i < answer.length; i++) {
			String result = nicknameMap.get(ids.get(i));
			result += getActions(i, actions);
			answer[i] = result;
		}
		
		return answer;
	}
	
	public static String getActions(int i, ArrayList<String> actions) {
		return actions.get(i).equals("Enter") ? SUFFIX_ENTER : SUFFIX_LEAVE;
	}
}
