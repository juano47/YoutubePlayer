package frsf.isi.dam.delaiglesia.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    YouTubePlayerView youTubePlayerView;
    String claveYouTube = "AIzaSyB8E2PSpswEvdHHpJGy_5aUULCCF2tVf2g";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(claveYouTube, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {
        if(!fueRestaurado){
            youTubePlayer.cueVideo("azxDhcKYku4");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }
        else{
            String error =  "Error al inicializar YouTube " + youTubeInitializationResult.toString();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == 1){
            getYouTubePlayerProvider().initialize(claveYouTube, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider(){
        return youTubePlayerView;
    }

    //métodos que faltarían implementar para  ver los controles
    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
