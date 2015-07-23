package yulongproductions.com.interactivestory.model;

/**
 * Created by Yulong on 7/19/2015.
 */
public class Choice {
    private String mText;
    private int mNextPage;

    public Choice(String text, int nextPage) {
        this.mText = text;
        this.mNextPage = nextPage;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public int getNextPage() {
        return this.mNextPage;
    }

    public void setNextPage(int nextPage) {
        this.mNextPage = nextPage;
    }
}
