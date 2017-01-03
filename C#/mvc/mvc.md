## mvc



* controller

  * 返回response.

    > 获得response,设置response，return content(response.的设置内容) 返回类	型为actionResult

    ***

    > 获得设置response.调用response.write .controller返回类型为void

  * 返回json

    返回类型为JsonResult,  return Json(xx)。

    ​

* route

  * IgnoreRoute

    > routes.IgnoreRoute("{resource}.ashx/{*pathInfo}");来让这种路径经过handler进行处理

