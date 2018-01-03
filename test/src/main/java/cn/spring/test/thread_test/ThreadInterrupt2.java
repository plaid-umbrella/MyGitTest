package cn.spring.test.thread_test;

public class ThreadInterrupt2 extends Thread{
	
	public void run()  
    {  
        try  
        {  
            sleep(10000);  // 延迟50秒  
            System.out.println("666666666666666666");  
        }  
        catch (InterruptedException e)  
        {  
            System.out.println(e.getMessage());  
        }  
    }  
    public static void main(String[] args) throws Exception  
    {  
        Thread thread = new ThreadInterrupt();  
        thread.start();  
        
//        System.out.println("在50秒之内按任意键中断线程!");  
//        System.in.read();  
//        thread.interrupt();  
//        thread.join();  
//        System.out.println("线程已经退出!");  
        System.out.println("我的代码继续执行");  
    }  

}
