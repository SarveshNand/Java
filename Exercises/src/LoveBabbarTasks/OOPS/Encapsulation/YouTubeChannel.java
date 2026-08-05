package LoveBabbarTasks.OOPS.Encapsulation;

public class YouTubeChannel {
    private String channelName;
    private int subscribers;
    private int videos;
    private int totalViews;
    private int watchHours;
    private boolean monetized;

    public YouTubeChannel(String channelName, int subscribers, int videos, int totalViews, int watchHours){
        this.channelName = channelName;
        this.subscribers = Math.max(subscribers, 0);
        this.videos = Math.max(videos, 0);
        this.totalViews = Math.max(totalViews, 0);
        this.watchHours = Math.max(watchHours, 0);
        this.monetized = false;
    }

    public void uploadVideo(){
        videos++;
        System.out.println("Video uploaded successfully.");
    }

    public void deleteVideo(){
        if (videos <= 0){
            System.out.println("Can't delete video.");
            return;
        }
        videos--;
        System.out.println("Video deleted successfully.");
    }

    public void subscribe(){
        subscribers++;
        System.out.println("Subscribed successfully.");
    }

    public void unsubscribe(){
        if (subscribers <= 0){
            System.out.println("No Subscribers available.");
            return;
        }
        subscribers--;
        System.out.println("Unsubscribed successfully.");
    }

    public void addViews(int views){
        if (videos <= 0){
            System.out.println("Upload videos first.");
            return;
        }
        if (views > 0){
            totalViews += views;
            System.out.println("Views added.");
        }
    }

    public void addWatchHours(int hours){
        if (hours > 0){
            watchHours += hours;
        }
    }

    public void monetizeChannel(){
        if (subscribers >= 1000 && watchHours >= 4000){
            monetized = true;
            System.out.println("Channel has been monetized successfully.");
        } else {
            System.out.println("Channel does not meet monetization requirements.");
        }
    }

    public String getChannelName() {
        return channelName;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public int getVideos() {
        return videos;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public boolean isMonetized() {
        return monetized;
    }
}
