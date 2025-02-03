

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 문자열을 ":" 기준으로 나누어 시, 분을 정수로 변환
    	
    	  String answer = "";
          
         
          
        String[] part_video = video_len.split(":");
        int video_hours = Integer.parseInt(part_video[0]); 
        int video_minutes = Integer.parseInt(part_video[1]);
        

        String[] part_start = op_start.split(":");
        int start_hours = Integer.parseInt(part_start[0]);
        int start_minutes = Integer.parseInt(part_start[1]);

        String[] part_end = op_end.split(":");
        int end_hours = Integer.parseInt(part_end[0]);
        int end_minutes = Integer.parseInt(part_end[1]);

        // 현재 위치(pos) 설정
        String[] part_pos = pos.split(":");
        int curr_hours = Integer.parseInt(part_pos[0]);
        int curr_minutes = Integer.parseInt(part_pos[1]);

        // 시간 단위 -> 분으로 변환
        int total_video_time = video_hours * 60 + video_minutes;
        int start_time = start_hours * 60 + start_minutes;
        int end_time = end_hours * 60 + end_minutes;
        int curr_time = curr_hours * 60 + curr_minutes;

        // 명령어 실행
        if (curr_time >= start_time && curr_time <= end_time) {
            curr_time = end_time;
        }
        
        
        for (String command : commands) {
            if (command.equals("next")) {
                curr_time += 10;
                if (curr_time > total_video_time) {
                	curr_time = total_video_time;  // 최대 초과 방지
                }
                if (curr_time >= start_time && curr_time <= end_time) {
                	curr_time = end_time;  // 오프닝 구간 내 조정
                }
            } 
            else if (command.equals("prev")) {
                curr_time -= 10;
                if (curr_time < 0) {
                	curr_time = 0;  // 0 이하 방지
                }
                if (curr_time >= start_time && curr_time <= end_time) {
                	curr_time = end_time;  // 오프닝 구간 내 조정
                }
            }
        }

        // 최종 시간 변환
        int final_hours = curr_time / 60;
        int final_minutes = curr_time % 60;

        
        
       if(( final_hours >=10)&&(final_minutes >= 10)) {
    	   
    	   answer =final_hours+":"+final_minutes;
       }
       else if(( final_hours >=10)&&(final_minutes < 10)){
    	   answer =final_hours+":"+ "0"+final_minutes;   
       }
       else if(( final_hours <10)&&(final_minutes >= 10)){
    	   answer ="0"+final_hours+":"+ final_minutes;   
       }
       else {
    	   answer ="0"+final_hours+":"+ "0"+final_minutes;   
       }
     
       
       return answer;
    }
 
}
