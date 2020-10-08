package naman.killtime.mavik1;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    public SimpleFragmentPagerAdapter(Context context ,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new NumbersFragment();
        }
        else if (position == 1)
        {
            return new FamilyFragment();
        }
        else  if(position == 2){
            return new ColorsFragment();
        } else
        {
            return new PhrasesFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}