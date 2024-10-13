package jonghyeok_97.week9;

public class 플그_1번_동영상재생기 {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] splitPos = pos.split(":");
        String[] splitVideo = video_len.split(":");
        String[] splitStart = op_start.split(":");
        String[] splitEnd = op_end.split(":");

        int posSecond = calculateSecond(splitPos[0], splitPos[1]);
        int videoSecond = calculateSecond(splitVideo[0], splitVideo[1]);
        int startSecond = calculateSecond(splitStart[0], splitStart[1]);
        int endSecond = calculateSecond(splitEnd[0], splitEnd[1]);

        for (String command : commands) {
            if (startSecond <= posSecond && posSecond <= endSecond) {
                posSecond = endSecond;
            }
            if ("prev".equals(command)) {
                posSecond -= 10;
                if (posSecond < 0) {
                    posSecond = 0;
                }
            }
            if ("next".equals(command)) {
                posSecond += 10;
                if (posSecond > videoSecond) {
                    posSecond = videoSecond;
                }
            }
        }
        if (startSecond <= posSecond && posSecond <= endSecond) {
            posSecond = endSecond;
        }
        return convertToTime(posSecond);
    }

    private int calculateSecond(String minute, String second) {
        return Integer.parseInt(minute) * 60 + Integer.parseInt(second);
    }

    private String convertToTime(int posSecond) {
        int minute = posSecond / 60;
        int second = posSecond % 60;
        return String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
}

