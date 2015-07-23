package yulongproductions.com.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import yulongproductions.com.interactivestory.R;
import yulongproductions.com.interactivestory.model.Page;
import yulongproductions.com.interactivestory.model.Story;


public class StoryActivity extends Activity {

    // Fields (Member Variables)
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    // Class constants
    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if (mName == null) {
            mName = "The Arkham Knight";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        // Starts the adventure at the first page
        loadPage(0);
    }

    // This method loads the page based on the choice the user makes, and gets the index of the page
    // It grabs the image from the resources and sets the page text and choices
    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());

        mImageView.setImageDrawable(drawable);
        String pageText = mCurrentPage.getText();
        // Add the name if placeholder included. Won't add if no placeholder
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        // Checks if the page is the last page, and if it is, it finishes the activity.
        if (mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else { // It's not the end of the story / final page yet
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            // Links the next pages based on first choice
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            // Links the choices based on second choice
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
