## c# array

* Array

  * ConvertAll

    ```
    int[] tagIdArray = Array.ConvertAll<string, int>(userIds.Split(new char[] { ',' }), s => int.Parse(s));
    ```

    ​

