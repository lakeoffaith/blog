## 高德地图 amap 显示 marker和自定义的infoWindow

##explains
在实现的app中需要查看附近的活动状态，就需要用到marker和自定义的infoWindow.实现这个功能我会去找下高德组件是否支持这个修改，通过查询，是可以的。百度 高德 marker android 图片，出来了很多图片，里面有很好的已经解决了效果图
[http://blog.csdn.net/zhoumushui/article/details/48804157](http://blog.csdn.net/zhoumushui/article/details/48804157)
进一步结合官方api能实现小的demo,但是，自定义InfoWindow没有，在github中搜索getInfoWindow 等修改infoWindow的方法，来找到了一些好的例子。
[https://github.com/JasonBour/learngit/blob/d82295bf16c8aaf3230e462ab7b3e05ad124b9fb/Newapp/src/com/example/fragments/FindFragment.java](https://github.com/JasonBour/learngit/blob/d82295bf16c8aaf3230e462ab7b3e05ad124b9fb/Newapp/src/com/example/fragments/FindFragment.java)
最终结果成功出现。
##code

    NormalActivity.java

```
public class NormalActivity extends FragmentActivity implements AMap.OnMarkerClickListener,AMap.OnInfoWindowClickListener,AMap.InfoWindowAdapter{
    static final CameraPosition cameraPosition=new CameraPosition.Builder().target(new LatLng(30.62275,104.068573))
            .zoom(18).bearing(0).tilt(30).build();
    private AMap aMap;
    private SupportMapFragment aMapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        AMapOptions aOptions=new AMapOptions();
        aOptions.zoomGesturesEnabled(false);
        //aOptions.scrollGesturesEnabled(false);
        aOptions.camera(cameraPosition);
        if(aMapFragment==null){
            aMapFragment=SupportMapFragment.newInstance(aOptions);
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(android.R.id.content,aMapFragment,"map");
            fragmentTransaction.commit();
        }
    }
    @Override
    protected  void onResume(){
        super.onResume();
        initMap();
    }
    private void initMap(){
        if(aMap==null){
            aMap=aMapFragment.getMap();
            setUpMap();
        }
    }
    private void setUpMap(){
        aMap.setOnMarkerClickListener(this);
        aMap.setOnInfoWindowClickListener(this);
        aMap.setInfoWindowAdapter(this);
        addMarkersToMap();   //
    }
    private void addMarkersToMap(){
        drawMarkers();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view  = getLayoutInflater().inflate(R.layout.activity_marker,null);
        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView info = (TextView)view.findViewById(R.id.info);
        TextView orderNumber=(TextView)view.findViewById(R.id.orderNumber);
        orderNumber.setText("2本");
        orderNumber.setTextColor(Color.parseColor("#FF0000"));
        info.setText(marker.getTitle());


        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    public void drawMarkers(){
        MarkerOptions markerOptions=new MarkerOptions();
        Marker marker=aMap.addMarker(markerOptions.position(new LatLng(30.624722,104.067533)).title("王泽陶")
                .draggable(true));
        marker.showInfoWindow();

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        System.out.println("点击了输入框");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        System.out.println("点击了图标");
        return false;
    }

}
```

	activity_marker.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal" >
 <ImageView
     android:src="@drawable/personimg"
     android:id="@+id/image"
     android:layout_width="30dp"
     android:layout_height="40dp"
     />
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <TextView
        android:id="@+id/info"
        android:layout_weight="1"
        android:layout_width="match_parent"
        android:layout_height="0dp"/>

    <TextView
        android:id="@+id/orderNumber"
        android:layout_weight="1"
        android:layout_width="match_parent"
        android:layout_height="0dp"
/>
</LinearLayout>
```

* * * 
      last update 2015-09-19