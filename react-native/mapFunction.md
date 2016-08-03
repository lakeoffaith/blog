##react native use map function
###question:
when i use this in map the this is not right.
###error code
```
class demo extends Component {
  show(name){
    ToastAndroid.show(name,ToastAndroid.SHORT);
  }
  render() {
    const data=[{name:1},{name:2}];
    return (
      <View style={styles.container}>
        {data.map(function(item,i){
          return(
           <TouchableHighlight onPress={()=>this.show('1')}>
            <View style={{heigh:60,flexDirection:'row'}}>
                <Text>{item.name}</Text>
              </View>
                </TouchableHighlight>
          );
        })}
      </View>
    );
  }
}
```
###right code
 we use other const to remember the this,so we can use it in map
```
class demo extends Component {
  show(name){
    ToastAndroid.show(name,ToastAndroid.SHORT);
  }
  render() {
    const data=[{name:1},{name:2}];
   const _this=this;
    return (

      <View style={styles.container}>
        {data.map(function(item,i){
          return(
           <TouchableHighlight onPress={()=>_this.show('1')}>
            <View style={{heigh:60,flexDirection:'row'}}>
                <Text>{item.name}</Text>
              </View>
                </TouchableHighlight>
          );
        })}
      </View>
    );
  }
}
```
