package com.core.op.lib.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.core.op.lib.R;
import com.core.op.lib.utils.inject.InjectUtil;
import com.core.op.lib.weight.picker.view.BasePickerView;

import javax.inject.Inject;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/12/21
 */
public abstract class BDialog<V extends BViewModel, T extends ViewDataBinding> extends BasePickerView {

    protected LayoutInflater inflater;

    protected V viewModel;

    protected T binding;

    public BDialog(Context context, V viewModel) {
        super(context);
        this.viewModel = viewModel;
        binding = DataBindingUtil.
                inflate(LayoutInflater.from(context), InjectUtil.injectFrgRootView(this), contentContainer, false);
        viewModel.setBinding(binding);
        bindViewModel();
        InjectUtil.injectAfterView(this);
    }

    protected abstract void bindViewModel();

}
