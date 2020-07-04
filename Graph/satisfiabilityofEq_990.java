public class satisfiabilityofEq_990{
    
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for(String eq: equations){
            if(eq.charAt(1)=='='){
                dsu.union(eq.charAt(0) -'a', eq.charAt(3)-'a');
            }
        }

        for(String eq:equations){
            if(eq.charAt(1)=='!'){
               if( dsu.connected(eq.charAt(0)-'a', eq.charAt(3)-'a'))
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        String[] equations = {"c==c","b==d","x!=z"};
        satisfiabilityofEq_990 sol = new satisfiabilityofEq_990();
        boolean result = sol.equationsPossible(equations);
        System.out.println(result);
    }
}