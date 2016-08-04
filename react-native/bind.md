##No .bind() or Arrow Function in JSX Props
###issue from
https://github.com/MichaelCereda/react-native-form-generator/issues/45

***warning code***
```
export class InputField extends React.Component{

  handleValidation(isValid, validationErrors){
    this.valid = isValid;
    this.validationErrors = validationErrors;
  }
  setValue(value){
    this.refs.fieldComponent.setValue(value)
  }
  focus(){
    this.refs.fieldComponent.focus()
  }
  render(){
    return(<InputComponent
      {...this.props}
      ref='fieldComponent'
      onValidation={this.handleValidation.bind(this)}
      //onChange={this.handleChange.bind(this)}
      //ref={this.props.fieldRef}
      />
    );
  }
}

```
***optimize code***
```
export class InputField extends React.Component{

  handleValidation(isValid, validationErrors){
    this.valid = isValid;
    this.validationErrors = validationErrors;
  }
  setValue(value){
    this.refs.fieldComponent.setValue(value)
  }
  focus(){
    this.refs.fieldComponent.focus()
  }
  render(){
    return(<InputComponent
      {...this.props}
      ref='fieldComponent'
      onValidation={this.handleValidation}
      />
    );
  }
}

```

###link read
- [readOne](https://github.com/yannickcr/eslint-plugin-react/blob/master/docs/rules/jsx-no-bind.md)
- [readTwo](http://reactkungfu.com/2015/07/why-and-how-to-bind-methods-in-your-react-component-classes/)

