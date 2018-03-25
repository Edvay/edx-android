package org.edx.mobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.inject.Inject;

import org.edx.mobile.base.BaseSingleFragmentActivity;
import org.edx.mobile.course.CourseAPI;
import org.edx.mobile.model.api.EnrolledCoursesResponse;
import org.edx.mobile.module.analytics.Analytics;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerView;

import org.edx.mobile.R;

public class CourseLiveClassActivity extends YouTubeBaseActivity
    implements
    YouTubePlayer.OnInitializedListener {

        private static final int RECOVERY_DIALOG_REQUEST = 1;

        // YouTube player view
        private YouTubePlayerView youTubeView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.fragment_live_class);

            youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

            // Initializing video player with developer key
            youTubeView.initialize("AIzaSyCDT3XEtu-XZMXBkgspNsqfioIEtj4kPYQ", this);

        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider,
                YouTubeInitializationResult errorReason) {
            if (errorReason.isUserRecoverableError()) {
                errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
            } else {


            }
        }

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                YouTubePlayer player, boolean wasRestored) {
            if (!wasRestored) {

                // loadVideo() will auto play video
                // Use cueVideo() method, if you don't want to play it automatically
                player.loadVideo("YFxXzzfixhA");

                // Hiding player controls
                player.setPlayerStyle(PlayerStyle.DEFAULT);
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == RECOVERY_DIALOG_REQUEST) {
                // Retry initialization if user performed a recovery action
                getYouTubePlayerProvider().initialize("AIzaSyCDT3XEtu-XZMXBkgspNsqfioIEtj4kPYQ", this);
            }
        }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

}