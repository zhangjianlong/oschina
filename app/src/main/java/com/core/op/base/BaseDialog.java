package com.core.op.base;

import com.core.op.BR;
import android.content.Context;
import android.databinding.ViewDataBinding;

import com.core.op.lib.base.BDialog;
import com.core.op.lib.base.BViewModel;



/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/12/21
 */
public class BaseDialog<V extends BViewModel, T extends ViewDataBinding> extends BDialog<V, T> {

    public BaseDialog(Context context, V viewModel) {
        super(context, viewModel);
    }

    @Override
    protected void bindViewModel() {
        binding.setVariable(BR.viewModel, viewModel);
    }
}
