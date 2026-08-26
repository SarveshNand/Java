package JavaMultithreading;

public class DownloadThread extends Thread{
    @Override
    public void run(){
        System.out.println("Downloading file...\nDownload completed");
    }
}
