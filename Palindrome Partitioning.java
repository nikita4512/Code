class Solution {
    //back+dp

    private Boolean[][] dp;
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        dp=new Boolean[s.length()+1][s.length()+1];
        res=new ArrayList<>();
        partition(new ArrayList<>(),s,0,0);
        return res;
}
    private void partition(List<String> back,String s,int curr,int arrSize){
        int n=s.length();
        if(curr==n){
            res.add(new ArrayList<>(back));
            return;
        }

        for(int i=curr+1;i<=n;i++){
            String temp =s.substring(curr,i);
            if(dp[curr][i]!=null){
                if(dp[curr][i]==true){
                    back.add(temp);
                    partition(back,s,i,arrSize+1);
                    back.remove(arrSize);
                }
            }
            else if(dp[curr][i]=isPalindrome(temp)){
                back.add(temp);
                partition(back,s,i,arrSize+1);
                back.remove(arrSize);
            }
        }

    }

    private boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1))
                return false;
        }
        return true;

    }
}
