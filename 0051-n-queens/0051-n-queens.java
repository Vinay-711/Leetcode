import java.util.*;
class Solution {
 public List<List<String>> solveNQueens(int n){List<List<String>> out=new ArrayList<>();search(0,n,new int[n],new boolean[n],new boolean[2*n],new boolean[2*n],out);return out;}
 private void search(int r,int n,int[] pos,boolean[] col,boolean[] d1,boolean[] d2,List<List<String>> out){
 if(r==n){List<String> board=new ArrayList<>();for(int c:pos){char[] line=new char[n];Arrays.fill(line,'.');line[c]='Q';board.add(new String(line));}out.add(board);return;}
 for(int c=0;c<n;c++){int a=r-c+n,b=r+c;if(col[c]||d1[a]||d2[b])continue;pos[r]=c;col[c]=d1[a]=d2[b]=true;search(r+1,n,pos,col,d1,d2,out);col[c]=d1[a]=d2[b]=false;}
 }
}