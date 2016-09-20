##Error converting bytecode to dex
Cause: com.android.dex.DexException: Multiple dex files define Landroid/support/v4/accessibilityservice/AccessibilityServiceInfoCompatIcs

##explain
该错误为引用了两个兼容包，anroid.support.v4  和 com.android.support:appcompat-v7,我们需要删除android.support.v4,因为com.android.support:appcompat-v7中包含android.support.v4.两个包支持的最低版本不同。


##ref

[http://stormzhang.com/android/2015/03/29/android-support-library/](http://stormzhang.com/android/2015/03/29/android-support-library/)

* * *
last update 2016-09-20