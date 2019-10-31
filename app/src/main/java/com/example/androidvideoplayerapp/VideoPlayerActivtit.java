package com.example.androidvideoplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoPlayerActivtit extends AppCompatActivity {

    PlayerView playerView;
    SimpleExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_video_player_activtit);
        playerView=findViewById(R.id.videoplayer);
        setScreenOrientation(getIntent().getStringExtra("path_file"));
    }

    private void showVideo(String filePath){
        exoPlayer= ExoPlayerFactory.newSimpleInstance(VideoPlayerActivtit.this);
        playerView.setPlayer(exoPlayer);
        DataSource.Factory datasource=new DefaultDataSourceFactory(VideoPlayerActivtit.this, Util.getUserAgent(VideoPlayerActivtit.this,getString(R.string.app_name)));

        MediaSource videoSource=new ExtractorMediaSource.Factory(datasource).createMediaSource(Uri.parse(filePath));
        exoPlayer.prepare(videoSource);
        exoPlayer.setPlayWhenReady(true);

        //working now
        //let's hide top bar
        //need to disable video on backpress and change video orientation

    }

    private void setScreenOrientation(String filePath){
        MediaPlayer mp=new MediaPlayer();
        try {
            mp.setDataSource(filePath);
            mp.prepare();
            mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    if(width<height){
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        showVideo(filePath);
                    }
                    else{
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        showVideo(filePath);
                    }

                    //i will display video when screen orientation changed successfully
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(exoPlayer!=null){
            exoPlayer.release();
        }

        if(exoPlayer!=null){
            if(exoPlayer.isLoading()) {
                exoPlayer.release();
            }
        }
        if(exoPlayer!=null){
            if(exoPlayer.isPlayingAd()) {
                exoPlayer.release();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(exoPlayer!=null){
            exoPlayer.release();
        }

        if(exoPlayer!=null){
            if(exoPlayer.isLoading()) {
                exoPlayer.release();
            }
        }
        if(exoPlayer!=null){
            if(exoPlayer.isPlayingAd()) {
                exoPlayer.release();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(exoPlayer!=null){
            exoPlayer.release();
        }

        if(exoPlayer!=null){
            if(exoPlayer.isLoading()) {
                exoPlayer.release();
            }
        }
        if(exoPlayer!=null){
            if(exoPlayer.isPlayingAd()) {
                exoPlayer.release();
            }
        }
    }
}
