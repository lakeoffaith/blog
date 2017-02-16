## mvc result之JavaScriptResult

* **源码**

```
public class JavaScriptResult : ActionResult
   {
       public override void ExecuteResult(ControllerContext context)
        {        
            HttpResponseBase response = context.HttpContext.Response;
            response.ContentType = "application/x-javascript";
            response.Write(this.Script);
        }
        public string Script { get; set; }
   }
    
   public abstract class Controller : ControllerBase, ...
   {
       //其他成员
       protected virtual JavaScriptResult JavaScript(string script);
   }
```

