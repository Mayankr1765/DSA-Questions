public class Solution {
    public int evalRPN(String[] A) {
        Stack<Integer> s = new Stack<>();
        for (int i=0;i<A.length;i++){
            if (isNumber(A[i])){
                int x = Integer.parseInt(A[i]);
                s.push(x);
            }
            else{
                int a = s.pop();
                int b = s.pop();
                int r = evaluateExpression(a,b,A[i]);
                s.push(r);

            }
        }
        return s.peek();
    }

    public boolean isNumber(String s){
        try{
            int n = Integer.parseInt(s);
            return true;

        }
        catch (NumberFormatException e){
        }
        return false;
    }

    public int evaluateExpression(int a,int b,String operator){
        if (operator.equals("+")){
            return a+b;
        }
        else if (operator.equals("-")){
            return b-a;
        }
        else if (operator.equals("/")){
            return b/a;
        }
        else {
            return a *b;
        }
        
    }
}
