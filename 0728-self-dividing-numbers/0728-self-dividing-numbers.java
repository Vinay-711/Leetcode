import java.util.*;
class Solution {
 public List<Integer> selfDividingNumbers(int left,int right){
 List<Integer> a=new ArrayList<>();
 for(int n=left;n<=right;n++){int x=n;boolean ok=true;while(x>0){int d=x%10;if(d==0||n%d!=0){ok=false;break;}x/=10;}if(ok)a.add(n);}return a;
 }
}
