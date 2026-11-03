class Solution {
 public int totalNQueens(int n){return count((1<<n)-1,0,0,0);}
 private int count(int all,int col,int left,int right){if(col==all)return 1;int free=all&~(col|left|right),ans=0;while(free!=0){int bit=free&-free;free-=bit;ans+=count(all,col|bit,((left|bit)<<1)&all,(right|bit)>>>1);}return ans;}
}