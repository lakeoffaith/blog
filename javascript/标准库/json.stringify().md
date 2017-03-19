# json.stringify()

* JSON.stringify()

  * JSON.stringify(obj,function(k,v))

    > 第一个参数为要序列化的JavaScript对象，第二个参数为函数，被序列化的值的每个属性都会经过这个函数的转换和处理

    ```
    var json = {
        "list": [{
            "class": [{
                "name": "1"
            }, {
                "name": "2"
            }, {
                "name": "3"
            }]
        }, {
            "name": "4"
        }, {
            "class": [{
                "name": "5"
            }, {
                "name": "6"
            }]
        }]
    };
     
    var arr = [];
    JSON.stringify(json,function (k,v) {
        if (k=="name")
            arr.push(v);
        return v;
    });
    alert(arr);
    ```

    ​

