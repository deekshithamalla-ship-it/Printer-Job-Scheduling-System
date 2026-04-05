import java.util.*;
public class project {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of jobs");
        int n=sc.nextInt();
        System.out.print("enter the speed of the printer");
        double speed=sc.nextDouble();
        String[] jobid=new String[n];
        int[] pages=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter Job Id:");
            jobid[i]=sc.next();
            System.out.print("Enter number of pages:");
            pages[i]=sc.nextInt();
        }
        double[] wt=new double[n];
        double[] tat=new double[n];
        double[] et=new double[n];
        for(int i=0;i<n;i++){
            et[i]=(double) pages[i]/speed;
        }
        wt[0]=0;
        for(int i=1;i<n;i++){
            wt[i]=wt[i-1]+et[i-1];
        }
        for(int i=0;i<n;i++){
            tat[i]=wt[i]+et[i];
        }
        double twt=0;
        double ttat=0;
        System.out.println("\n--- job Scheduling results---");
        for(int i=0;i<n;i++){
            System.out.printf("%s: Waiting = %.2f mins,Turnaround=%.2f mins\n",jobid[i],wt[i],tat[i]);
            twt+=wt[i];
            ttat+=tat[i];
        }
        System.out.printf("\nAverage Waiting Time is=%.2f mins",twt/n);
        System.out.printf("\nAverage Turnaround Time is=%.2f mins",ttat/n);
        sc.close();
    }
}
