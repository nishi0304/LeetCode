class Solution {
    public int reverseBits(int n) {
        int[] bits= new int[32];
        for(int i=0;i<32;i++){
            bits[i]=n & 1;
            n>>>=1;
                    }
        int answer=0;
        for(int i =0;i<32;i++){
            answer=(answer<<1)| bits[i];
        }
         return answer;
    }
   
}