## Gradle的编译版本过高

安装错误: Gradle 的编译版本过高, 不兼容部分5.0+手机, 需要降低版本为 1.3.

Installing APK 'app-debug.apk' on 'HUAWEI GRA-TL00 - 5.0.1' for app:debugError while uploading app-debug.apk : Unknown failure ([CDS]close[0])

使用 Android Studio 打开 React Native 的项目, 修改最外层工程的 build.gradle 配置, 降低 gradle的 build 为1.2.3版本.

buildscript {    repositories {        jcenter()        mavenLocal()    }    dependencies {        classpath 'com.android.tools.build:gradle:1.2.3' // 修改1.2.3        classpath 'de.undercouch:gradle-download-task:2.0.0'        // NOTE: Do not place your application dependencies here; they belong        // in the individual module build.gradle files    }}

需要重新设置 Gradle 的 Wrapper , 修改为2.2版本.

Gradle version 2.2 is required. Current version is 2.11