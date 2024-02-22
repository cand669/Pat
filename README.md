

w = '''<style name="{}">
<item name="android:layout_weight">1</item>
<item name="android:orientation">vertical</item>
<item name="android:layout_width">wrap_content</item>
<item name="android:layout_height">wrap_content</item>
</style>'''
for _ in 'jact-wead-zall-kun'.split('-'):
s = w.format(_)
print(s)

from Base import *
activity_layout_temp = '''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
style="@style/flai">

    <Button
        android:id="@+id/but"
        style="@style/crif"
        android:text="activity_{}" />
</LinearLayout>'''
def activity_kt_temp(i,r,m):
return '''package com.example.'''+m+'''.activity
import com.example.'''+m+'''.core.BaseActivity
import com.example.cat.databinding.Activity'''+r+'''Binding

class '''+r+'''Activity : BaseActivity<Activity'''+r+'''Binding>() {
override fun InitView() {
}
}'''

a_l_p = pathlib.Path(r'E:\win\share\Cat\app\src\main\java\com\example\cat\activity')
a_t_p = pathlib.Path(r'E:\win\share\Cat\app\src\main\res\layout')
def func(i:str,m:str):
w_activity_layout = activity_layout_temp.format(i)
with open(a_t_p / f'activity_{i}.xml','w') as f:
f.write(w_activity_layout)
f.close()
r = i.capitalize()
w_activity_kt_temp = activity_kt_temp(i,r,m)
with open(a_l_p / f'{r}Activity.kt','w') as f:
f.write(w_activity_kt_temp)
f.close()
func('test','cat')

[//]: # ()
from Base import *
fragment_layout_temp = '''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
style="@style/flai">

    <Button
        android:id="@+id/but"
        style="@style/crif"
        android:text="fragment_{}" />
</LinearLayout>'''

f_l_p = pathlib.Path(r'E:\win\share\Cat\app\src\main\java\com\example\cat\fragment')
f_t_p = pathlib.Path(r'E:\win\share\Cat\app\src\main\res\layout')


def fragmnet_kt_temp(i,r,m):
return '''package com.example.'''+i+'''.fragment

import com.example.'''+m+'''.core.BaseFragment
import com.example.cat.databinding.Fragment'''+r+'''Binding

class '''+r+'''Fragment : BaseFragment<Fragment'''+r+'''Binding>() {
override fun InitView() {

    }
}'''

[//]: # ()
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
func('cand','cat')