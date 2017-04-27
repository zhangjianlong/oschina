package com.core.op.feature.detail.base.act;


import android.view.MenuItem;

import com.core.op.R;
import com.core.op.base.BaseActivity;
import com.core.op.databinding.ActDetailBinding;
import com.core.op.lib.base.BAViewModel;
import com.core.op.lib.utils.inject.RootView;

@RootView(R.layout.act_detail)
public abstract class DetailActivity<V extends BAViewModel> extends BaseActivity<V, ActDetailBinding> {

    @Override
    protected void initAfterView() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.initAfterView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
