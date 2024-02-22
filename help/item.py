from Base import *
item_layout_temp = '''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    style="@style/flai">
    <Button
        android:id="@+id/v_but_0"
        android:text="item_{}_0"
        style="@style/crif"/>
</LinearLayout>'''

def func(i):
    with open(f_t_p / f'item_{i}.xml', 'w') as f:
        f.write(item_layout_temp.format(i))
        f.close()
func('yuns')