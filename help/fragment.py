from Base import *
fragment_layout_temp = '''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    style="@style/flai">

    <Button
        android:id="@+id/but"
        style="@style/crif"
        android:text="fragment_{}" />
</LinearLayout>'''

f_l_p = pathlib.Path(r'E:\win\share\Cat\app\src\main\java\com\example\cat\fragment\cand')



def fragmnet_kt_temp(i,r,m):
    return '''package com.example.'''+i+'''.fragment

import com.example.'''+m+'''.core.BaseFragment
import com.example.cat.databinding.Fragment'''+r+'''Binding

class '''+r+'''Fragment : BaseFragment<Fragment'''+r+'''Binding>() {
    override fun InitView() {

    }
}'''

def func(i:str,m:str):
    i = i.lower()
    w_activity_layout = fragment_layout_temp.format(i)
    with open(f_t_p / f'fragment_{i}.xml','w') as f:
        f.write(w_activity_layout)
        f.close()
    r = i.capitalize()
    w_activity_kt_temp = fragmnet_kt_temp(i, r, m)
    with open(f_l_p / f'{r}Fragment.kt', 'w') as f:
        f.write(w_activity_kt_temp)
        f.close()
    fragmnet_kt_temp(i,r,m)
func('bxc','cat')