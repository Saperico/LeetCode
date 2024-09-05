public class a2028MissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int roll:rolls)
            sum+=roll;
        int total = mean*(rolls.length+n);
        if(sum+n>total || sum +6*n < total)
            return new int[]{};
        int missing = total - sum;
        int[] missingRolls = new int[n];
        int i =0;
        while(n-1>0 && (missing-6)>=n){
            missingRolls[i]=6;
            n--;
            missing-=6;
            i++;
        }
        if(n==1)
            missingRolls[i]=missing;
        else {
            while (missing > 0) {
                if (missing > n) {
                    missingRolls[i] = missing - n + 1;
                    missing -= missing - n + 1;
                } else {
                    missingRolls[i] = 1;
                    missing--;
                }
                i++;
            }
        }
        return missingRolls;
    }

    public static void main(String[] args)
    {
        int[] rolls = {6,1,6,2,4,4,5};
        int mean = 5;
        int n = 16;
        a2028MissingObservations observations = new a2028MissingObservations();
        int[] result = observations.missingRolls(rolls,mean,n);
        for(int r:result)
            System.out.println(r);
    }
}
