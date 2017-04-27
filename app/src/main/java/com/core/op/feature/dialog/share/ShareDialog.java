package com.core.op.feature.dialog.share;

import android.content.Context;

import com.core.op.R;
import com.core.op.base.BaseDialog;
import com.core.op.databinding.DlgShareBinding;
import com.core.op.lib.utils.inject.AfterViews;
import com.core.op.lib.utils.inject.RootView;

import javax.inject.Inject;

@RootView(R.layout.dlg_share)
public final class ShareDialog extends BaseDialog<ShareViewModel, DlgShareBinding> {

    @Inject
    public ShareDialog(Context context, ShareViewModel viewModel) {
        super(context, viewModel);
    }

    @AfterViews
    void afterViews() {
    }
}
