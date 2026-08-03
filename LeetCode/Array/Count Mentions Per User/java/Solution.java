class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

       
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;

            
            if (a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if (a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });

        for (List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String info = event.get(2);

            
            for (int i = 0; i < numberOfUsers; i++) {
                if (offlineUntil[i] <= time) {
                    offlineUntil[i] = 0;
                }
            }

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(info);
                offlineUntil[user] = time + 60;
            } 
            else { 
                if (info.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
                }
                else if (info.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (offlineUntil[i] == 0) mentions[i]++;
                    }
                }
                else {
                    String[] parts = info.split(" ");
                    for (String p : parts) {
                        int user = Integer.parseInt(p.substring(2));
                        mentions[user]++;
                    }
                }
            }
        }

        return mentions;
    }
}
