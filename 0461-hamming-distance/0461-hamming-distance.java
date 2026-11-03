class Solution {
 public int hammingDistance(int x,int y) {
  int bits=x^y,count=0;
  while(bits!=0){bits &= bits-1;count++;}
  return count;
 }
}
