##Promise and AsyncStorage React Native
  	Promise in javascript is the seventh type,is (key,value),is chain.
  
  	AsyncStorage is globe variable like (key,value);many methods they return Promise.

***use***
```
DataRepository.prototype._safeFetch=function(reqUrl:string){
  console.log(reqUrl);
  return new Promise((resolve,reject)=>{
    fetch(reqUrl)
    .then((response)=>response.json())
    .then((responseData)=>{
      console.log(responseData);
      let result=[]
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
```
	this method is to fetch data from url;return Promise object,Promise constructor should be a method with two parameters(resolve,reject).they are a two method,resolve is success,reject is false.

```
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
```
	fetchHospital continue deal the Promise object,get from the _safeFetch ,usually in this method we should deal localStorage and fetch to return the new values.

```
    fetchHospital(){
     repository.fetchHospital()
      .then((dataArray)=>{
         console.log(dataArray);
         this.setState({
           DS:this.state.DS.cloneWithRows(dataArray)
         })
      })
      .catch((error)=>{
        console.error(error);
      })
      .done();
  }
```
	
    in the index.android.js,wo can get the promise object,to add a new chain,to setState.
  