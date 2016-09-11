
##use custom middleware for async actions

####explain
当使用异步加载的时候需要加入插件thunk,插件需要传入applyMiddleWare方法，如果这个时候还加入了devtool插件，applyMiddleWare(thunk)必须要放在devtool()的前面，否则会报错。


####ref

[http://stackoverflow.com/questions/38474276/redux-devtools-uncaught-error-actions-must-be-plain-objects-use-custom-middlew](http://stackoverflow.com/questions/38474276/redux-devtools-uncaught-error-actions-must-be-plain-objects-use-custom-middlew)

* * *
last update 2015-09-06