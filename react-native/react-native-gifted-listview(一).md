#react-native-gifted-listview(一)

##for
 use gifted-listview 显示列表

##step

1. list.js


```
	/*
  use react-native-gifted-listview for ijoy list show
*/
import React,{Component} from 'react';
import {
  View,
  Text,
  ListView,
  StyleSheet,
  Dimensions,
  TouchableHighlight
} from 'react-native';

import DataRepository from './DataRepository';
import GiftedListView from 'react-native-gifted-listview';
const repository=new DataRepository();
const height=Dimensions.get("window").height;
const toobarHeight=59;
const sectionHeight=height-toobarHeight;
export default class List extends Component{
  constructor(){
    super();
    const ds=new ListView.DataSource({rowHasChanged:(r1,r2)=>r1!==r2});
    this.state={
      DS:ds.cloneWithRows([]),
      loaded:false,
      dataArray:[]
    }
  }
  fetchHospital(){
  repository.fetchHospital()
   .then((dataArray)=>{
      console.log(dataArray);
      this.setState({
        DS:this.state.DS.cloneWithRows(dataArray),
        loaded:true,
        dataArray:dataArray
      })
   })
   .catch((error)=>{
     console.error(error);
   })
   .done();
}
  componentDidMount(){
    const tt=this.fetchHospital();
    console.log('----------------');
    console.log(tt);
  }
  _onFetch=(page = 1, callback, options)=> {
   setTimeout(() => {
     var rows =this.state.dataArray;
     if (page === 3) {
       callback(rows, {
         allLoaded: true, // the end of the list is reached
       });
     } else {
       callback(rows);
     }
   }, 1000); // simulating network fetching
 }
  _renderRowView=(rowData)=> {
   return (
     <TouchableHighlight
       style={styles.row}
       underlayColor='#c8c7cc'

     >

       <Text>{rowData.name}</Text>
     </TouchableHighlight>
   );
 }
  render(){
    if(this.state.loaded===false)return (<View><Text>正在加载</Text></View>)
    return(
      <View style={styles.container}>
        <View style={styles.navBar} />
        <GiftedListView
          rowView={this._renderRowView}
          onFetch={this._onFetch}
          firstLoader={true} // display a loader for the first fetching
          pagination={true} // enable infinite scrolling using touch to load more
          refreshable={true} // enable pull-to-refresh for iOS and touch-to-refresh for Android
          withSections={false} // enable sections
          enableEmptySections={true}
          customStyles={{
            paginationView: {
              backgroundColor: '#eee',
            },
          }}

          refreshableTintColor="blue"
        />
      </View>
    );
  }
}
const styles=StyleSheet.create({
  container: {
   flex: 1,
   backgroundColor: '#FFF',
 },
 navBar: {
   height: 64,
   backgroundColor: '#CCC'
 },
 row: {
   padding: 10,
   height: 44,
 }
})
```

2.	DataRepository.js

```
'use strict';
const API_HOSPITAL_LIST="http://www.tngou.net/api/hospital/list";
function DataRepository() { // Singleton pattern
  if (typeof DataRepository.instance === 'object') {
    return DataRepository.instance;
  }

  DataRepository.instance = this;
}
DataRepository.prototype.fetchHospital=function(callback?:?(error:?Error,result:?Object)=>void){
    const reqUrl=API_HOSPITAL_LIST;
    const networking=this._safeFetch(reqUrl);
    const merged=new Promise((resolve,reject)=>{
      Promise.all([networking])
        .then((values)=>{
           console.log('-------------resulte---------------');
           console.log(values);
           resolve(values[0]);
        })
    });
    return merged;
}
DataRepository.prototype._safeFetch=function(reqUrl:string){
  console.log(reqUrl);
  return new Promise((resolve,reject)=>{
    fetch(reqUrl)
    .then((response)=>response.json())
    .then((responseData)=>{
      console.log(responseData);
      let result=[];
      result=responseData.tngou;
       resolve(result);
    })
    .catch((error)=>{
      console.error(error);
      resolve(null);
    })
  }
  );
}

module.exports=DataRepository;
```

* * *
last update 2016-08-31
