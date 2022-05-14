public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-1);
        Stack<Integer> s = new Stack<>();
        s.push(A.get(0));
        for (int i=1;i<A.size();i++){
            if (s.size() == 0){
                a.add(-1);
            }
            else if  (s.size() > 0 && A.get(i)> s.peek()){
                a.add(s.peek());
                s.push(A.get(i));
           }
           else if (s.size() > 0 && A.get(i) <= s.peek()){
               while (!s.isEmpty() && A.get(i) <= s.peek()){
                   s.pop();
               }
               if (s.size() == 0){
                   a.add(-1);
                   s.push(A.get(i));
               }
               else{
                   a.add(s.peek());
                   s.push(A.get(i));
               }
           }
            
            
        }
        return a;
    }
}
