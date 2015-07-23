package yulongproductions.com.interactivestory.model;

/**
 * Created by Yulong on 7/19/2015.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    public Page(int imageId, String text) {
        this.mImageId = imageId;
        this.mText = text;
        this.mChoice1 = null;
        this.mChoice2 = null;
        this.mIsFinal = true;
    }

    public Page(int imageId, String text, Choice c1, Choice c2) {
        this.mImageId = imageId;
        this.mText = text;
        this.mChoice1 = c1;
        this.mChoice2 = c2;
    }

    public boolean isFinal() {
        return this.mIsFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.mIsFinal = isFinal;
    }

    public int getImageId() {
        return this.mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public Choice getChoice1() {
        return this.mChoice1;
    }

    public void setChoice1(Choice choice1) {
        this.mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return this.mChoice2;
    }

    public void setChoice2(Choice choice2) {
        this.mChoice2 = choice2;
    }
}
