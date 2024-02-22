

w = '''<style name="{}">
     <item name="android:layout_weight">1</item>
     <item name="android:orientation">vertical</item>
     <item name="android:layout_width">wrap_content</item>
     <item name="android:layout_height">wrap_content</item>
</style>'''
for _ in 'jact-wead-zall-kun'.split('-'):
    s = w.format(_)
    print(s)
