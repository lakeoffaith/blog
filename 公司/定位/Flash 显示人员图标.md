## Flash 显示人员图标

* 加载js


​	![加载js](img/flash_1.png)

* 配置flash的配置

   之后就会根据配置的访问路径不停的去获取maplist,map,mapfile,maparea,tag等消息，返回xml

* controller返回flash 所需要的xml




* 程序流程

  > /Flash/xml/MapArea.ashx?mapId=29	

  ```
  <?xml version="1.0" standalone="yes" ?>

  <areaList>

  	<area id="49" name="库房区域"  coordinatesArray="0.31,2.82|1.92,2.83|1.92,4.25|0.29,4.27|0.30,4.28" quota="2" currentCount="0" mapId="-1" />

  </areaList>
  ```

  > /Flash/xml/TagCoordinates.ashx?mapId=29&keyword=&eventtypes=&pagesize=5&currentpage=1&taggroups=2,4&tagid=null&time=1482808917495

  ```
  <?xml version="1.0" standalone="yes" ?> 

  <tagCoordinates>

  <pagination>

  <recordCount>1</recordCount>

  <pageSize>5</pageSize>

  <currentPage>1</currentPage>

  </pagination>

  <coordinates id="34" mapId="29" mapName="WPDEMO" coordinatesName="02" x="3.98" y="2.57"><tag id="5849" tagName="心电检测仪" warningTypes="" warningLevel="1" moveSpeed="2" icon="/Images/culprit.gif" updateTime="2016/12/27 11:22:02"  groupIds="2" /></coordinates>

  </tagCoordinates>
  ```

  > /Flash/xml/LatestEvents.ashx	
  >
  > <?xml version="1.0" standalone="yes" ?>

  ```
  <LatestEvents>

  	<item id='5' tagId='5850' tagMac='00:1F:00:1F:00:1F' tagName='人员测试' coordinatesId='33' coodinatesName='1A' eventType='4' eventDescription='电量不足' lastHappenTime='2016/12/27 10:48:20' hostGroupID='1' />

  	<item id='4' tagId='5849' tagMac='00:BB:00:BB:00:BB' tagName='心电检测仪' coordinatesId='34' coodinatesName='02' eventType='2' eventDescription='无警官监管' lastHappenTime='2016/11/16 11:53:22' hostGroupID='2' />

  </LatestEvents>

  ```

  > /NetRadio.Assistant/Ajax.ashx?type=NetRadio.Common.LocatingMonitor.ThreadingAjax, CommonMonitor&method=GetNewEventCounts&session=true

  ```
  {"TotalCount":2,"LatestCount":1,"TimePoint":"16-12-20 	16:34:09","MakeSound":false,"LatestTime":"\/Date(1482806900973+0800)\/"}
  ```

  > /Monitor/Ajax/AjaxMethod.ashx?typeFullName=NetRadio.LocatingMonitor.__Default&methodName=LocatingServerIsOnline&assemblyName=NetRadio.LocatingMonitor&rdm=0.6429034744498929	

  ```
  {"value":true,"error":0,"errorText":null}
  ```

  ​

  ​

  ​

  IServiceApi serviceApi = LocatingServiceUtil.Instance<IServiceApi>();   

  serviceApi为空

  ​		<add key="ConnectionString" value="Data Source=192.168.2.150;Initial Catalog=demo;User ID=sa;Password=black"/>

  allowscriptaccess="sameDomain"

  ，而视频网站的flash就会受到限制，比如有的视频网站flash会在播放完毕后跳转到自己的站点，此时你设置了sameDomain他就没法跳了