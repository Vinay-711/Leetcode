class Solution {
 public boolean checkPerfectNumber(int n) {
  if(n<2)return false;
  long sum=1;
  for(int d=2;d<=n/d;d++)if(n%d==0){sum+=d;if(d!=n/d)sum+=n/d;}
  return sum==n;
 }
}
