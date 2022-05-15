public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {

        ArrayList<Integer> nsla = new ArrayList<>();
        ArrayList<Integer> nsra = new ArrayList<>();

        nsla = nsl(A);
        nsra = nsr(A);
        int res[] = new int[A.size()];
        int max = -1;
        for (int i =0;i<A.size();i++){
             res[i] = ((nsra.get(i) - nsla.get(i)) -1) * A.get(i);
            max = max > res[i] ? max : res[i];
        }
        return max;
    }

    public ArrayList<Integer> nsl(ArrayList<Integer> A){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> ele = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        res.add(-1);
        ele.push(A.get(0));
        ind.push(0);

        for (int i=1;i<A.size();i++){
            if (A.get(i)> ele.peek()){
                res.add(ind.peek());
                ele.push(A.get(i));
                ind.push(i);
            }
            else{
                while (!ele.isEmpty() && A.get(i)<= ele.peek()){
                    ele.pop();
                    ind.pop();
                }

                if (ele.size() ==0){
                    res.add(-1);
                    ele.push(A.get(i));
                    ind.push(i);
                }
                else{
                    res.add(ele.peek());
                    ele.push(A.get(i));
                    ind.push(i);
                }
            }
        }

        return res;

    }

    public ArrayList<Integer> nsr(ArrayList<Integer> A){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> ele = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        res.add(A.size());
        ele.push(A.get(A.size()-1));
        ind.push(A.size());

        for (int i=A.size()-1;i>=0;i--){
            if (A.get(i)> ele.peek()){
                res.add(ind.peek());
                ele.push(A.get(i));
                ind.push(i);
            }
            else{
                while (!ele.isEmpty() && A.get(i)<= ele.peek()){
                    ele.pop();
                    ind.pop();
                }

                if (ele.size() ==0){
                    res.add(-1);
                    ele.push(A.get(i));
                    ind.push(i);
                }
                else{
                    res.add(ele.peek());
                    ele.push(A.get(i));
                    ind.push(i);
                }
            }
        }
        Collections.reverse(res);

        return res;


    }
}
