package ocjp.threads;

class MyThread implements Runnable{

    @Override
    public void run() {

        System.out.println("Thread ID:"+Thread.currentThread().getId()+" executing");
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
