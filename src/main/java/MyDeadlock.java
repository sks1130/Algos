
public class MyDeadlock {
 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
        	int i=1;
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2 + i);
                        i++;
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
        	int j=1;
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1+j);
                        j++;
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}