MultiLineRadioGroup
===================
RadioGroup with multiLine (多行的RadioGroup)

#### 程序截图：

![http://img.my.csdn.net/uploads/201505/07/1430962690_1083.jpg](http://img.my.csdn.net/uploads/201505/07/1430962690_1083.jpg)
![http://img.my.csdn.net/uploads/201505/07/1430962690_4852.jpg](http://img.my.csdn.net/uploads/201505/07/1430962690_4852.jpg)
![http://img.my.csdn.net/uploads/201505/07/1430962690_6160.jpg](http://img.my.csdn.net/uploads/201505/07/1430962690_6160.jpg)

#### 使用说明：

1.定义一个MultiLineRadioGroup的layout(Define a layout to hold the MultiLineGroup);
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
    
    <org.ccflying.MultiLineRadioGroup
        android:id="@+id/content"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:child_count="8"
        app:child_layout="@layout/child"
        app:child_margin_horizontal="6.0dip"
        app:child_margin_vertical="2.0dip"
        app:child_values="@array/childvalues"
        app:gravity="1"
        app:single_choice="true" >
    </org.ccflying.MultiLineRadioGroup>
</LinearLayout>

2.为MultiLineGroup指定单个Child元素对应的layout资源,该layout资源的要节点必须是CheckBox (define the attr child_layout in MultiLineRadioGroup,which root is a CheckBox.);
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
    
    <CheckBox xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="wrap_content" />
</LinearLayout>

3.指定其它属性

    child_count : 指定默认child个数;
    child_margin_horizontal : 指定child水平间距;
    child_margin_vertical : 指定child垂直间距;
    child_values : 指定child的textArray值(一个string-array);
    single_choice : 单选或多选;
    gravity : 对齐方式    1(left) 0(center) 2(right);

4.部分方法
  *  append(String str) 附加一个child;
  *  insert(int position, String str) 往指定位置插入child;
  *  getCheckedValues()|getCheckedItems() 获取选中项;
  *  remove(int position) 删除指定位置的child;
  *  setItemChecked(int position) 选中指定位置的child;
  *  setGravity(int gravity) 设定child的对齐方式(left|right|center);
  *  ...


