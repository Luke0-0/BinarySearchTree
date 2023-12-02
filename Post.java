public class Post {
    String title;
    String video;
    int numLikes;

    public Post (String t, String v, int n) {
        title = t;
        video = v;
        numLikes = n;
    }

    public String toString() {
        return title + ' ' + video + ' ' + numLikes;
    }


}


