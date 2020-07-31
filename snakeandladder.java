import java.util.*;
public class snakeandladder {

  static int p1=-1,p2=-1,t=0,in1=0,in2=0;
  static int n=0,n1=0,dice,count=0,first=0,second=0,cou;
  static int[][] gameBoard=new int[10][10];
  int snakeHead[]={55,64,45};
  int snakeTail[]={7,33,10};
   int ladderHead[]={69,22,89};
   int ladderTail[]={28,8,43};
    public int dicevalue()
    {
        Random r = new Random();
        int a=r.nextInt(6)+1;
        return a;
    }

     void player1()                                                          
    {
        
        System.out.println("Player1 turn");
       
        dice=dicevalue();
       
        System.out.println("dice value  "+dice);
        System.out.println();
       
        while(dice==6)                                                      
        {
           ++first;
           ++count;
           ++cou;
           
           System.out.println();
           System.out.println("Player1 turn    ");
           
           dice=dicevalue();
           
           if(in1==0 && dice==6)
           count-=1;
           
           System.out.println("dice value "+dice);
           System.out.println();
           
           in1=1;
        }
       
        if(cou>=3 && n==0){                                              
        in1=0;
            n=1;
            t++;  
        }
        else if(in1==1 && (count>0 && count<3) && first!=1){          
        p1+=(count)*6+dice;
            t++;
            if(p1>99)
            p1-=(count)*6+dice;
        }
        else if(in1==1){
        p1+=dice;
            t++;
             if(p1>99)
                p1-=dice;
        }
        else
        ++t;
       
        System.out.println();
       
          for(int i=0;i<3;i++)
        {
            
            if(p1==snakeHead[i])
            {
            p1-=(snakeHead[i]-snakeTail[i]);
            System.out.println("Snakebite player1");
            break;
            }
            if(p1==ladderTail[i])
            {
            p1+=(ladderHead[i]-ladderTail[i]);
            System.out.println("ladder player1");
            break;
            }
        }
       
        System.out.println();
       
        System.out.println("player1 value "+p1);
       
        for(int i=0;i<10;i++)                                             
        {
        for(int j=0;j<10;j++)
        {
        if(gameBoard[i][j]==p1)
        System.out.print("P1 ");
        else if(gameBoard[i][j]==p2)
        System.out.print("P2 ");
        else
        System.out.print(gameBoard[i][j]+" ");
        }
        System.out.println();
        }
    }
     
     
     void player2()
    {
        
        System.out.println("                                   Player2 turn    ");
       
        dice=dicevalue();
       
        System.out.println("                                   dice value "+dice);
        System.out.println();
       
        while(dice==6)
        {
           
           ++second;
           ++count;
           ++cou;
           
           System.out.println();
           System.out.println("                                   Player2 turn    ");
           
           dice=dicevalue();
           
           if(in2==0 && dice==6)
           count-=1;
           
           System.out.println("                                   dice value "+dice);
           System.out.println();
           
           in2=1;  
        }
       
       if(cou>=3 && n1==0){
            in2=0;
            n1=1;
            t++;
        }
        else if(in2==1 && (count>0 && count<3) && second!=1){
        p2+=(count)*6+dice;
            t++;
             if(p2>99)
            p2-=(count)*6+dice;
        }
        else if(in2==1){
        p2+=dice;
            t++;
            if(p2>99)
            p2-=dice;
        }
        else
        t++;

           for(int i=0;i<3;i++)
        {
            
            if(p2==snakeHead[i])
            {
            p2-=(snakeHead[i]-snakeTail[i]);
            System.out.println("                                 Snakebite player2");
            break;
            }
            if(p2==ladderTail[i])
            {
            p2+=(ladderHead[i]-ladderTail[i]);
            System.out.println("                                 ladder player2");
            break;
            }
        }
       
       System.out.println();
     
    System.out.println("                                          Player2 value "+p2);
   
       for(int i=0;i<10;i++)
       {
       System.out.print("                                          ");
        for(int j=0;j<10;j++)
        {
          if(gameBoard[i][j]==p2)
      System.out.print("P2 ");
          else if(gameBoard[i][j]==p1)
      System.out.print("P1 ");
      else
      System.out.print(gameBoard[i][j]+" ");
        }
          System.out.println();
       }
    }
     
     
    public static void main(String args[]) {
   
    int k=0;
   
    for (int i = 9; i >=0; i--)                                                     
{
if (((10-i) % 2)!=0)
{
for (int j = 0; j < 10; j++)
gameBoard[i][j]=k++;
}
else
{
for (int j = 9; j >= 0; j--)
gameBoard[i][j]=k++;
}

}
   
    Scanner s =new Scanner(System.in);
   
    snakeandladder my=new snakeandladder();
       
     while(p1<=99 || p2<=99)                              
     {
         count=0;cou=0;
         
         if(t%2==0)
              my.player1();
         else                           
              my.player2();
         
         if((p1==p2) && (t%2==0))
        p1=-1;                                                                              
         else if((p1==p2) && (t%2!=0))
        p2=-1;
         
         if(p1==99)
         {
        System.out.println();
             System.out.println(" Winner is Player1   "+p1);
             break;
         }
         else if(p2==99)
         {
        System.out.println();
             System.out.println("Winner is Player2   "+p2);
             break;
         }
    
     }
     
    }
}