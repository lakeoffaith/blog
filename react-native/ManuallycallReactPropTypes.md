##Manually calling a React.PropTypes validation React native
###issue
    i git clone a existed project,npm install ,the issue appear.
###resolution
    my version:
    	 "react": "^15.2.1",
    	  "react-native": "^0.29.2",
    do:
    	npm --save remove react react-native
        npm --save install react@15.2.0 react-native@0.29.0
        
    the question will be fixed.
    
###other
	React native 0.30 was dependtent on react 15.2.0 not 15.2.1
    if you want to use React native 0.30
    npm --save remove react react-native
    npm --save install react@15.2.0 react-native@0.30.0
    
    React native 0.31 was dependtent on react 15.2.1


###ref
	[http://stackoverflow.com/questions/38690502/manually-calling-a-react-proptypes-validation-react-native-0-30-0](http://stackoverflow.com/questions/38690502/manually-calling-a-react-proptypes-validation-react-native-0-30-0)