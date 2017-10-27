//package org.edx.mobile.view;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.text.TextUtils;
//
//import com.google.inject.Inject;
//
//import org.edx.mobile.base.BaseSingleFragmentActivity;
//import org.edx.mobile.course.CourseAPI;
//import org.edx.mobile.model.api.EnrolledCoursesResponse;
//import org.edx.mobile.module.analytics.Analytics;
//
//
//public class CourseLiveClassActivity extends BaseSingleFragmentActivity {
//
//    @Inject
//    CourseAPI api;
//
//    private EnrolledCoursesResponse courseData;
//
//
//    public static String TAG = CourseLiveClassActivity.class.getCanonicalName();
//
//    Bundle bundle;
//    String activityTitle;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        bundle = savedInstanceState != null ? savedInstanceState :
//                getIntent().getBundleExtra(Router.EXTRA_BUNDLE);
//
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        invalidateOptionsMenu();
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }
//
//    @Override
//    public Fragment getFirstFragment() {
//        CourseLiveClassFragment fragment = new CourseLiveClassFragment();
//
//
//        return fragment;
//    }
//}
