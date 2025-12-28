import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicT = fees[0];
        int basicF = fees[1];
        int plusT = fees[2];
        int plusF = fees[3];

        List<Integer> list = new ArrayList<>();

        node[] arr = new node[records.length];

        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" ");
            arr[i] = new node(temp[0], temp[1], temp[2]);
        }

        Arrays.sort(arr); // 정렬 유지

        int i = 0;
        while (i < arr.length) {
            String car = arr[i].no;

            int totalTime = 0;     // 이 차량의 누적 주차 시간(분)
            Integer in = null;     // 마지막 IN 시간(분)

            // 같은 차량번호 구간 처리
            while (i < arr.length && arr[i].no.equals(car)) {
                int t = toMin(arr[i].time);
                if (arr[i].io.equals("IN")) {
                    in = t;
                } else { // OUT
                    totalTime += (t - in);
                    in = null;
                }
                i++;
            }

            // OUT 없이 끝난 경우 23:59 처리
            if (in != null) {
                totalTime += (23 * 60 + 59) - in;
            }

            // 요금 계산
            int price;
            if (totalTime <= basicT) {
                price = basicF;
            } else {
                int extra = totalTime - basicT;
                price = basicF + ((extra + plusT - 1) / plusT) * plusF; // 올림
            }

            list.add(price);
        }

        int[] ans = new int[list.size()];
        for (int k = 0; k < ans.length; k++) ans[k] = list.get(k);
        return ans;
    }

    private int toMin(String time) {
        String[] a = time.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }
}

class node implements Comparable<node> {
    String time;
    String no;
    String io;

    public node(String time, String no, String io) {
        this.time = time;
        this.no = no;
        this.io = io;
    }

    public int compareTo(node o) {
        int c = this.no.compareTo(o.no);       // 차량번호 오름차순 (문자열로도 OK: 4자리)
        if (c != 0) return c;
        return this.time.compareTo(o.time);    // 같은 차량이면 시간 오름차순
    }
}
