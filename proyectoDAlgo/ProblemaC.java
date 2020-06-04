import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Autores Camilo Salinas y Daniel Perilla
public class ProblemaC {

  public static void main (String[] args) {
    MyScanner sc = new MyScanner();

    int n, k;
    
    while((n = sc.nextInt()) != 0 && (k = sc.nextInt()) != 0){
      int a[] = new int[n];
      int p[] = new int[n];
      int m[] = new int[k];
      int c[] = new int[k];
      
      int maxDp = 0;
      for(int i = 0 ; i < n ; ++i)
      a[i] = sc.nextInt();
      for(int i = 0 ; i < n ; ++i)
      p[i] = sc.nextInt();
      for(int i = 0 ; i < k ; ++i){
        m[i] = sc.nextInt();
        maxDp = Math.max(maxDp, m[i]);
      }
      for(int i = 0 ; i < k ; ++i)
      c[i] = sc.nextInt();
      
      int dp[] = new int[++maxDp];

      for(int i = 1 ; i < maxDp ; ++i){
        dp[i] = dp[i-1];
        for(int j = 0 ; j < n ; ++j){
          if(i-a[j] < 0) continue;
          dp[i] = Math.max(dp[i-a[j]] + p[j], dp[i]);
        }
      }

      int prov = 0, g = Integer.MIN_VALUE;
      for(int i = 0 ; i < k ; ++i) {
        if(dp[m[i]] - c[i] > g){
          prov = i+1;
          g = dp[m[i]] - c[i];
        }
      }

      if(g <= 0){
        System.out.println("0 -1");
      }
      else
        System.out.println(prov + " " + g);
    }
  }

  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() {
      return Integer.parseInt(next());
    }
  }

}