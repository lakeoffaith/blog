##react-native 与原生互相调用

##explain
react-native也相当于一个activity，所以他启动原生activity，我们需要新建一个module，在其中新建启动原生activity的方法，如果传参数就用intent;如果需要返回的话就需要用到回调函数；同样有原生activity启动react-native同样点击按钮，触发方法，启动react-native的activity,传递参数就用intent.

##code

	1.index.android.js   调用nativemodules.

```
_goNative=()=>{
    NativeModules.MyMapIntentModule.startActivityByClassname('com.demo.MapActivity',"盘古花园")
  }
```

	2.MyMapIntentModule.java  nativemodule启动原生activity,并传递参数

```
public class MyMapIntentModule extends ReactContextBaseJavaModule{
    @Override
    public String getName() {
        return "MyMapIntentModule";
    }

    public MyMapIntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    public final  static String EXTRA_SECTIONNAME="com.demo.MyMapIntentModule.sectionName";
    @ReactMethod
    public void startActivityByClassname(String activityClassName,String sectionName){
        try{
            System.out.println("nihao"+activityClassName);
            Activity currentActivity=getCurrentActivity();
            Class aimActivity=Class.forName(activityClassName);
            Intent intent=new Intent(currentActivity,aimActivity);
            intent.putExtra(EXTRA_SECTIONNAME,sectionName);
            currentActivity.startActivity(intent);


        }catch (Exception e){
            throw  new JSApplicationCausedNativeException(
                    "Could not open the activity :" +e.getMessage()
            );
        }
    }
}
```

	3.MapActivity   原生模块，原生模块启动React native Activity.通过Intent传递参数
	4.MyMapIntentModule.java  通过getDataFromIntent 方法取得参数

```
  @ReactMethod
    public void getDataFromIntent(Callback successBack,Callback errorBack){
        try {
            Activity currentActivity=getCurrentActivity();
            String result=currentActivity.getIntent().getStringExtra(MapActivity.EXTRA_PERSONNAME);
            System.out.println("enter getDataFromIntent     ="+result);
            successBack.invoke(result);
        }catch (Exception e){
            errorBack.invoke(e.getMessage());
        }
    }
```

5.index.android.js  调用nativemodule的getDataFromIntent的方法来获取数据，方法返回类型都为void，则必须要通过回调函数来返回。

##refs
[https://github.com/ipk2015/RN-Resource-ipk/tree/master/react-native-docs](https://github.com/ipk2015/RN-Resource-ipk/tree/master/react-native-docs)


* * *
last update 2016-09-20



