class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int[] f1 = new int[26]; // s1 freq
        int[] f2 = new int[26]; // sliding window freq

        for(int i=0; i<s1.length(); i++){
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        //check matched
        int matched = 0;
        for(int i=0; i<26; i++){
            if(f1[i] == f2[i]){
                matched++;
            }
        }

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++){
            if(matched == 26) return true;

            //add elem from right
            int r = s2.charAt(right)-'a';
            //before adding
            if(f1[r] == f2[r]){
                matched--;
            }
            f2[r]++;
            //after adding
            if(f1[r] == f2[r]){
                matched++;
            }

            //remove elem from left
            int l = s2.charAt(left)-'a';
            //before removing
            if(f1[l] == f2[l]){
                matched--;
            }
            f2[l]--;
            //after adding
            if(f1[l] == f2[l]){
                matched++;
            }

            left++;
        }

    return matched == 26;

    }
}
