package cmpsc475.emc37.cico.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import cmpsc475.emc37.cico.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

  @StringRes
  private static final int[] TAB_TITLES = new int[]{R.string.log, R.string.search, R.string.data};
  private final Context mContext;

  public SectionsPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }

  @Override
  public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    // Return a PlaceholderFragment (defined as a static inner class below).
     int fragmentID = -1;
    switch (position) {
      case 0:
        fragmentID = R.layout.log_fragment;
        break;
      case 1:
        fragmentID = R.layout.search_fragment;
        break;
      case 2:
        fragmentID = R.layout.data_fragment;
        break;

    }
    return new Fragment(fragmentID);
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return mContext.getResources()
                   .getString(TAB_TITLES[position]);
  }

  @Override
  public int getCount() {
    return TAB_TITLES.length;
  }
}