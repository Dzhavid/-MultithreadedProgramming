 class MyThread  extends Thread{
    MyThread (String name){
        super(name); // =Thread(String threadName);
       // super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " - запуск.");
        try{
            for (int count = 0; count < 10 ; count++) {
                super.sleep(400);
                System.out.println("B " + getName() + " ,счетчик: " +
                        count);
            }
        }catch(InterruptedException e){
            System.out.println(getName() + " прерван!");
        }
        System.out.println(getName() + " завершение.");
    }
}
public class ExtendThread{
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");
        MyThread m = new MyThread("Порожденный поток №1");
        m.start();
        for (int i = 0; i < 50 ; i++) {
            System.out.print(".");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
