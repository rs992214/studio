package es.iessaladillo.pedrojoya.pr173;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_BSB_STATE = "STATE_BSB_STATE";

    private ImageView imgDetail;

    private BottomSheetBehavior<RelativeLayout> bsb;
    private int bsbState = BottomSheetBehavior.STATE_COLLAPSED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_main);
        restoreInstanceState(savedInstanceState);
        initViews();
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            bsbState = savedInstanceState.getInt(STATE_BSB_STATE, BottomSheetBehavior
                    .STATE_COLLAPSED);
        }
    }

    private void initViews() {
        imgDetail = ActivityCompat.requireViewById(this, R.id.imgDetail);
        RelativeLayout rlPanel = ActivityCompat.requireViewById(this, R.id.rlPanel);
        bsb = BottomSheetBehavior.from(rlPanel);
        FloatingActionButton fab = ActivityCompat.requireViewById(this, R.id.fab);
        setupBottomSheet();
        imgDetail.setOnClickListener(view -> expandOrCollapseBottomSheet());
        fab.setOnClickListener(v -> searchDailyPhoto());
    }

    private void setupBottomSheet() {
        //bsb.setPeekHeight(getResources().getDimensionPixelSize(R.dimen
        // .bottomSheet_peekHeight));
        bsb.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                setupIcon(newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        bsb.setState(bsbState);
        setupIcon(bsb.getState());
    }

    private void setupIcon(int newState) {
        switch (newState) {
            case BottomSheetBehavior.STATE_EXPANDED:
                imgDetail.setImageResource(R.drawable.ic_arrow_drop_down_white_24dp);
                break;
            case BottomSheetBehavior.STATE_COLLAPSED:
            case BottomSheetBehavior.STATE_HIDDEN:
                imgDetail.setImageResource(R.drawable.ic_arrow_drop_up_white_24dp);
                break;
            default:
        }
    }

    private void searchDailyPhoto() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, getString(R.string.main_activity_daily_photo));
        startActivity(intent);
    }

    private void expandOrCollapseBottomSheet() {
        if (bsb.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bsb.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (bsb.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bsb.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_BSB_STATE, bsb.getState());
    }

}
