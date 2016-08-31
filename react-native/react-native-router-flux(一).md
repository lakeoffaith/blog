#react-native-router-flux(一)
##navigator with redux react native

####for####
在采用了redux的项目中实现navigator的跳转。采用 react-native-router-flux +redux

#####explain####
-	在Route标签中的component属性将redux加入组件中，
-	在Router标签中Connect a <Router> to redux
triggeractions
	Actions.BEFORE_ROUTE
    Actions.AFTER_ROUTE
    Actions.AFTER_POP
    Actions.BEFORE_POP
    Actions.AFTER_DISMISS
    Actions.BEFORE_DISMISS
    
    
-	在reducer中state.set('currentRoute',action.name)
-	update you component on focus
-	
    ```
    componentDidUpdate(prevProps) {
        const prevRoute = prevProps.global.currentRoute
        const currentRoute = this.props.global.currentRoute
        if (currentRoute === 'payment' && prevRoute !== currentRoute) {
          this.props.actions.doSomething()
        }
      }
    ```
####ref####

[http://stackoverflow.com/questions/35140116/accessing-navigator-in-actions-with-react-native-and-redux](http://stackoverflow.com/questions/35140116/accessing-navigator-in-actions-with-react-native-and-redux)

* * *
last update 2016-08-31




####ref####