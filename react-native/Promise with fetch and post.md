## Promise with fetch and post

##code

post fetch

```
var API_POST_EVENTS = "http://navyblue.top/events/";

handlePress(event) {
    var _navigator = this.props.navigator;

    fetch(API_POST_EVENTS, {
       method: 'post',
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
    body: JSON.stringify({
        name: this.state.eventName,
        priority: this.state.eventPriority,
        stamp_type: this.state.eventDeadline,
        project_type: this.state.eventType,
      })
    })
    .then(function(json) {
        _navigator.pop();
        ToastAndroid.show('Add event success!', ToastAndroid.SHORT);
    })
    .catch(function(ex) {
        ToastAndroid.show('Add event failed!', ToastAndroid.SHORT);
    })

  },
```

get fetch

```
DataRepository.prototype._safeFetch = function(reqUrl: string) {
  return new Promise((resolve, reject) => {
    fetch(reqUrl)
      .then((response) => response.json())
      .then((responseData) => {
        resolve(responseData);
      })
      .catch((error) => {
        console.error(error);
        resolve(null);
      });
  });
};

DataRepository.prototype.getEvents = function(
  callback?: ?(error: ?Error, result: ?Object) => void
) {
    return this._safeFetch(HOME_PROJECT_MAIN)
    .then((responseData) => {
      return responseData;
    });
}
```

###refs
[http://navyblue.top/article/61](http://navyblue.top/article/61)

* * * 
last update 2016-09-11