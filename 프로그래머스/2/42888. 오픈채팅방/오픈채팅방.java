import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        
        List<String> list = new ArrayList();
        Map<String, String> map = new HashMap();
        
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                // 채팅방 입장
                map.put(temp[1], temp[2]);
                list.add(temp[1]+"님이 들어왔습니다.");
            }else if(temp[0].equals("Leave")){
                // 채팅방 퇴장
                list.add(temp[1]+"님이 나갔습니다.");
            }else{
                // 닉네임 변경
                map.put(temp[1], temp[2]);
            }
        }
        
        answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            String[] temp = list.get(i).split("님이 ");
            answer[i] = list.get(i).replace(temp[0], map.get(temp[0]));
        }
        return answer;
    }
}