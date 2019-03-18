package com.heyskill.latte_core.ui.launcher;



import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.heyskill.latte_core.R;

public class LauncherHolder extends Holder<Integer> {

    private ImageView mImageView ;

    public LauncherHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mImageView =  itemView.findViewById(R.id.item_image);
    }

    @Override
    public void updateUI(Integer data) {
        mImageView.setImageResource(data);
    }
}
