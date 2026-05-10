class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        List<Character>[] res = new ArrayList[numRows];

        for(int i=0; i<numRows; i++){
            res[i] = new ArrayList<>();
        }

        int row=0, dir=1;

        for(int i=0; i<s.length(); i++){
            res[row].add(s.charAt(i));
            row = row + dir;
            if(row == 0 || row == numRows-1){
                dir = dir * -1;
            }
        }

        StringBuilder result = new StringBuilder();

        for(List<Character> rowList : res){
            for(char c : rowList){
                result.append(c);
            }
        }

        return result.toString();
    }
}