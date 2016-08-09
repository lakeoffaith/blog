## how to make React Native ListView When click on row make the row different
###example code###

```
import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ListView,
  TouchableWithoutFeedback
} from 'react-native';
const peopleArray=[{id:'1',name:'lilei'},{id:'2',name:'zhangsan'}]
class demo extends Component {
  constructor(){
    super();
    const ds=new ListView.DataSource({rowHasChanged:(r1,r2)=>r1!==r2});
    this.state={
      data:peopleArray,
      DS:ds.cloneWithRows([])
    }
  }
  componentDidMount(){
    this.setState({DS:this.state.DS.cloneWithRows(this.state.data)});
  }
  renderRow=(item)=>{
    return (
      <TouchableWithoutFeedback onPress={()=>this.handlePress(item)}>
         <View style={styles.item}>
            {item.onPressed?
              <Text>click</Text>
              :<Text>{item.name}</Text>
            }

         </View>
      </TouchableWithoutFeedback>
    );
  }
  handlePress(itemData){
    const dataClone=peopleArray;
    for (var i = 0; i < dataClone.length; i++) {
         dataClone[i].onPressed=false;
       if(dataClone[i]==itemData){
         dataClone[i].onPressed=true;
       }
    }
    this.setState({
      data:dataClone
    });
  }
  render() {
    return (
      <View style={styles.container}>
          <ListView
              dataSource={this.state.DS}
              renderRow={this.renderRow}
          />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#F5FCFF',
  },
  item:{
    height:40,
    borderBottomWidth:1,
    justifyContent:'center',
    alignItems:'center'
  }
});

AppRegistry.registerComponent('demo', () => demo);
```
***relate***
  http://stackoverflow.com/questions/33663461/react-native-listview-row-not-re-rendering-after-state-change

