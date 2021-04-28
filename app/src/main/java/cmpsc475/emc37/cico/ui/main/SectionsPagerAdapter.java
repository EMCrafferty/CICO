package cmpsc475.emc37.cico.ui.main;

import android.content.Context;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import cmpsc475.emc37.cico.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

  @StringRes
  private static final int[] TAB_TITLES = new int[]{
      R.string.log, R.string.search, R.string.data
  };

  @LayoutRes
  private static final int[] LAYOUT_IDS = new int[]{
      R.layout.log_fragment, R.layout.search_fragment, R.layout.data_fragment
  };
  private final Context mContext;

  public SectionsPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }

  @NotNull
  @Override
  public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    return new Fragment(LAYOUT_IDS[position]);
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