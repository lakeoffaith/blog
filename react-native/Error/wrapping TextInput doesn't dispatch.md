##wrapping TextInput doesn't dispatch
##Touchable doesn't dispatch onPress event when wrapping TextInput

## explain
当实现点击不可编辑的textInput，让包含的view触发onPress事件，不会触发，解决方案为将TextInput修改成Text,这样就可以变通的解决问题了。

##ref

[https://github.com/facebook/react-native/issues/6476](https://github.com/facebook/react-native/issues/6476)
